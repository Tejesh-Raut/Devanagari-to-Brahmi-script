/* Service worker for the Devanagari <-> Brahmi Converter PWA.
   Bump CACHE when any precached asset changes to force an update. */
const CACHE = 'brahmi-v8';
const ASSETS = [
  './',
  './index.html',
  './manifest.webmanifest',
  './Fonts/NotoSansBrahmi-Regular.ttf',
  './Fonts/NotoSansDevanagari-Regular.ttf',
  './icons/icon-192.png',
  './icons/icon-512.png',
  './icons/icon-maskable-512.png',
  './icons/apple-touch-icon.png',
  './icons/favicon-16.png',
  './icons/favicon-32.png',
  './icons/favicon-48.png',
  './assets/asoka-edicts.jpg',
  './assets/brahmi-inscription.jpg',
  './assets/brahmi-vowel-signs.jpg'
];

// Precache the app shell.
self.addEventListener('install', (event) => {
  event.waitUntil(
    caches.open(CACHE)
      .then((cache) => cache.addAll(ASSETS))
      .then(() => self.skipWaiting())
  );
});

// Clean up old caches on activation.
self.addEventListener('activate', (event) => {
  event.waitUntil(
    caches.keys()
      .then((keys) => Promise.all(keys.filter((k) => k !== CACHE).map((k) => caches.delete(k))))
      .then(() => self.clients.claim())
  );
});

self.addEventListener('fetch', (event) => {
  const req = event.request;
  if (req.method !== 'GET') return;

  // Only handle same-origin requests; let cross-origin calls (e.g. the
  // transliteration API) go straight to the network, always fresh.
  if (new URL(req.url).origin !== self.location.origin) return;

  // Navigations: try network first, fall back to the cached page when offline.
  if (req.mode === 'navigate') {
    event.respondWith(
      fetch(req).catch(() => caches.match('./index.html'))
    );
    return;
  }

  // Everything else (fonts, icons, manifest): cache-first, then network.
  event.respondWith(
    caches.match(req).then((cached) => {
      if (cached) return cached;
      return fetch(req).then((res) => {
        const copy = res.clone();
        caches.open(CACHE).then((cache) => cache.put(req, copy)).catch(() => {});
        return res;
      });
    })
  );
});
