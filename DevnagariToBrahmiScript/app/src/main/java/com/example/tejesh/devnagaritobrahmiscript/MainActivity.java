package com.example.tejesh.devnagaritobrahmiscript;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView outputDB, devanagari, outputBD, brahmi;
    Button buttonDB, buttonBD;
    String devanagariText, brahmiText, outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface brahmiFont = Typeface.createFromAsset(getAssets(), "fonts/NotoSansBrahmi-Regular.ttf");
        Typeface devanagariFont = Typeface.createFromAsset(getAssets(), "fonts/NotoSansDevanagari-Regular.ttf");

        outputDB = (TextView)findViewById(R.id.outputDB);
        outputDB.setTypeface(brahmiFont);

        outputBD = (TextView)findViewById(R.id.outputBD);
        outputBD.setTypeface(devanagariFont);

        buttonDB = (Button)findViewById(R.id.buttonDB);
        buttonBD = (Button)findViewById(R.id.buttonBD);

        devanagari = (TextView)findViewById(R.id.devanagari);
        devanagari.setTypeface(devanagariFont);
        brahmi = (TextView)findViewById(R.id.brahmi);
        brahmi.setTypeface(brahmiFont);

        buttonDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                devanagariText = devanagari.getText().toString();
                outputText = DevanagariToBrahmi(devanagariText);
                outputDB.setText(Html.fromHtml(outputText));
            }
        });

        buttonBD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                brahmiText = brahmi.getText().toString();
                outputText = BrahmiToDevanagari(brahmiText);
                outputBD.setText(Html.fromHtml(outputText));
            }
        });

        TextView references = (TextView)findViewById(R.id.references);
        references.setMovementMethod(LinkMovementMethod.getInstance());
        TextView footer = (TextView)findViewById(R.id.footer);
        footer.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private String DevanagariToBrahmi(String devanagariText) {
        String b="";
        int len = devanagariText.length();
        String c="";
        for(int i=0; i<len; i++){
            int n = devanagariText.codePointAt(i);
            switch (n){
                case 0x905: //A
//                    c = new String(new int[] { 0x11005 }, 0, 1);
//                    c = getUnicodeChar(0x11005);
//                    Log.d("c",c);
                    b += getUnicodeChar(0x11005);
                    break;
                case 0x906: //AA
                    b += getUnicodeChar(0x11006);
                    break;
                case 0x907: //I
                    b += getUnicodeChar(0x11007);
                    break;
                case 0x908: //II
                    b += getUnicodeChar(0x11008);
                    break;
                case 0x909: //U
                    b += getUnicodeChar(0x11009);
                    break;
                case 0x90A: // UU
                    b += getUnicodeChar(0x1100A);
                    break;
                case 0x90B: //Vocalic R
                    b += getUnicodeChar(0x1100B);
                    break;
                case 0x90C: //Vocalic L
                    b += getUnicodeChar(0x1100D);
                    break;
                case 0x90F: // E
                    b += getUnicodeChar(0x1100F);
                    break;
                case 0x910: // AI
                    b += getUnicodeChar(0x11010);
                    break;
                case 0x913: // O
                    b += getUnicodeChar(0x11011);
                    break;
                case 0x914: // AU
                    b += getUnicodeChar(0x11012);
                    break;
                case 0x915: // KA
                    b += getUnicodeChar(0x11013);
                    break;
                case 0x916: // KHA
                    b += getUnicodeChar(0x11014);
                    break;
                case 0x917: // GA
                    b += getUnicodeChar(0x11015);
                    break;
                case 0x918: // GHA
                    b += getUnicodeChar(0x11016);
                    break;
                case 0x919: // NGA
                    b += getUnicodeChar(0x11017);
                    break;
                case 0x91A: // CA
                    b += getUnicodeChar(0x11018);
                    break;
                case 0x91B: // CHA
                    b += getUnicodeChar(0x11019);
                    break;
                case 0x91C: // JA
                    b += getUnicodeChar(0x1101A);
                    break;
                case 0x91D: // JHA
                    b += getUnicodeChar(0x1101B);
                    break;
                case 0x91E: // NYA
                    b += getUnicodeChar(0x1101C);
                    break;
                case 0x91F: // TTA
                    b += getUnicodeChar(0x1101D);
                    break;
                case 0x920: // TTHA
                    b += getUnicodeChar(0x1101E);
                    break;
                case 0x921: // DDA
                    b += getUnicodeChar(0x1101F);
                    break;
                case 0x922: // DDHA
                    b += getUnicodeChar(0x11020);
                    break;
                case 0x923: // NNA
                    b += getUnicodeChar(0x11021);
                    break;
                case 0x924: // TA
                    b += getUnicodeChar(0x11022);
                    break;
                case 0x925: // THA
                    b += getUnicodeChar(0x11023);
                    break;
                case 0x926: // DA
                    b += getUnicodeChar(0x11024);
                    break;
                case 0x927: // DHA
                    b += getUnicodeChar(0x11025);
                    break;
                case 0x928: // NA
                    b += getUnicodeChar(0x11026);
                    break;
                case 0x92A: //PA
                    b += getUnicodeChar(0x11027);
                    break;
                case 0x92B: //PHA
                    b += getUnicodeChar(0x11028);
                    break;
                case 0x92C: // BA
                    b += getUnicodeChar(0x11029);
                    break;
                case 0x92D: // BHA
                    b += getUnicodeChar(0x1102A);
                    break;
                case 0x92E: // MA
                    b += getUnicodeChar(0x1102B);
                    break;
                case 0x92F: // YA
                    b += getUnicodeChar(0x1102C);
                    break;
                case 0x930: // RA
                    b += getUnicodeChar(0x1102D);
                    break;
                case 0x932: // LA
                    b += getUnicodeChar(0x1102E);
                    break;
                case 0x933: // LLA
                    b += getUnicodeChar(0x11034);
                    break;
                case 0x935: // VA
                    b += getUnicodeChar(0x1102F);
                    break;
                case 0x936: // SHA
                    b += getUnicodeChar(0x11030);
                    break;
                case 0x937: // SSA
                    b += getUnicodeChar(0x11031);
                    break;
                case 0x938: // SA
                    b += getUnicodeChar(0x11032);
                    break;
                case 0x939: // HA
                    b += getUnicodeChar(0x11033);
                    break;
                case 0x93E: // AA
                    b += getUnicodeChar(0x11038);
                    break;
                case 0x93F: // I
                    b += getUnicodeChar(0x1103A);
                    break;
                case 0x940: // II
                    b += getUnicodeChar(0x1103B);
                    break;
                case 0x941: // U
                    b += getUnicodeChar(0x1103C);
                    break;
                case 0x942: //UU
                    b += getUnicodeChar(0x1103D);
                    break;
                case 0x943: //R
                    b += getUnicodeChar(0x1103E);
                    break;
                case 0x944: //RR
                    b += getUnicodeChar(0x1103F);
                    break;
                case 0x962: //L
                    b += getUnicodeChar(0x11040);
                    break;
                case 0x963: //LL
                    b += getUnicodeChar(0x11041);
                    break;
                case 0x947: //E
                    b += getUnicodeChar(0x11042);
                    break;
                case 0x948: //AI
                    b += getUnicodeChar(0x11043);
                    break;
                case 0x94B: //O
                    b += getUnicodeChar(0x11044);
                    break;
                case 0x94C: //AU
                    b += getUnicodeChar(0x11045);
                    break;
                case 0x94D: //virama
                    b += getUnicodeChar(0x11046);
                    break;
                case 0x964: // danda
                    b += getUnicodeChar(0x11047);
                    break;
                case 0x965: // double danda
                    b += getUnicodeChar(0x11048);
                    break;
                case 0x966: //0
                    b += getUnicodeChar(0x11066);
                    break;
                case 0x967: //1
                    b += getUnicodeChar(0x11067);
                    break;
                case 0x968: //2
                    b += getUnicodeChar(0x11068);
                    break;
                case 0x969: //3
                    b += getUnicodeChar(0x11069);
                    break;
                case 0x96A: //4
                    b += getUnicodeChar(0x1106A);
                    break;
                case 0x96B: //5
                    b += getUnicodeChar(0x1106B);
                    break;
                case 0x96C: //6
                    b += getUnicodeChar(0x1106C);
                    break;
                case 0x96D: //7
                    b += getUnicodeChar(0x1106D);
                    break;
                case 0x96E: //8
                    b += getUnicodeChar(0x1106E);
                    break;
                case 0x96F: //9
                    b += getUnicodeChar(0x1106F);
                    break;
                default:
//                    c = new String(new int[]{n}, 0,1);
//                    c = "?";
//                    Log.d("c",c);
                    b += getUnicodeChar(n);
                    break;
            }
        }
        return b;
    }

    private String BrahmiToDevanagari(String brahmiText) {
        String b="";
        int len = brahmiText.length();
        String c="";
        for(int i=0; i<len; i++){
            int n = brahmiText.codePointAt(i);
            switch (n){
                case 0x11005: //A
//                    c = new String(new int[] { 0x11005 }, 0, 1);
//                    c = getUnicodeChar(0x11005);
//                    Log.d("c",c);
                    b += getUnicodeChar(0x905);
                    i++;
                    break;
                case 0x11006: //AA
                    b += getUnicodeChar(0x906);
                    i++;
                    break;
                case 0x11007: //I
                    b += getUnicodeChar(0x907);
                    i++;
                    break;
                case 0x11008: //II
                    b += getUnicodeChar(0x908);
                    i++;
                    break;
                case 0x11009: //U
                    b += getUnicodeChar(0x909);
                    i++;
                    break;
                case 0x1100A: // UU
                    b += getUnicodeChar(0x90A);
                    i++;
                    break;
                case 0x1100B: //Vocalic R
                    b += getUnicodeChar(0x90B);
                    i++;
                    break;
                case 0x1100D: //Vocalic L
                    b += getUnicodeChar(0x90C);
                    i++;
                    break;
                case 0x1100F: // E
                    b += getUnicodeChar(0x90F);
                    i++;
                    break;
                case 0x11010: // AI
                    b += getUnicodeChar(0x910);
                    i++;
                    break;
                case 0x11011: // O
                    b += getUnicodeChar(0x913);
                    i++;
                    break;
                case 0x11012: // AU
                    b += getUnicodeChar(0x914);
                    i++;
                    break;
                case 0x11013: // KA
                    b += getUnicodeChar(0x915);
                    i++;
                    break;
                case 0x11014: // KHA
                    b += getUnicodeChar(0x916);
                    i++;
                    break;
                case 0x11015: // GA
                    b += getUnicodeChar(0x917);
                    i++;
                    break;
                case 0x11016: // GHA
                    b += getUnicodeChar(0x918);
                    i++;
                    break;
                case 0x11017: // NGA
                    b += getUnicodeChar(0x919);
                    i++;
                    break;
                case 0x11018: // CA
                    b += getUnicodeChar(0x91A);
                    i++;
                    break;
                case 0x11019: // CHA
                    b += getUnicodeChar(0x91B);
                    i++;
                    break;
                case 0x1101A: // JA
                    b += getUnicodeChar(0x91C);
                    i++;
                    break;
                case 0x1101B: // JHA
                    b += getUnicodeChar(0x91D);
                    i++;
                    break;
                case 0x1101C: // NYA
                    b += getUnicodeChar(0x91E);
                    i++;
                    break;
                case 0x1101D: // TTA
                    b += getUnicodeChar(0x91F);
                    i++;
                    break;
                case 0x1101E: // TTHA
                    b += getUnicodeChar(0x920);
                    i++;
                    break;
                case 0x1101F: // DDA
                    b += getUnicodeChar(0x921);
                    i++;
                    break;
                case 0x11020: // DDHA
                    b += getUnicodeChar(0x922);
                    i++;
                    break;
                case 0x11021: // NNA
                    b += getUnicodeChar(0x923);
                    i++;
                    break;
                case 0x11022: // TA
                    b += getUnicodeChar(0x924);
                    i++;
                    break;
                case 0x11023: // THA
                    b += getUnicodeChar(0x925);
                    i++;
                    break;
                case 0x11024: // DA
                    b += getUnicodeChar(0x926);
                    i++;
                    break;
                case 0x11025: // DHA
                    b += getUnicodeChar(0x927);
                    i++;
                    break;
                case 0x11026: // NA
                    b += getUnicodeChar(0x928);
                    i++;
                    break;
                case 0x11027: //PA
                    b += getUnicodeChar(0x92A);
                    i++;
                    break;
                case 0x11028: //PHA
                    b += getUnicodeChar(0x92B);
                    i++;
                    break;
                case 0x11029: // BA
                    b += getUnicodeChar(0x92C);
                    i++;
                    break;
                case 0x1102A: // BHA
                    b += getUnicodeChar(0x92D);
                    i++;
                    break;
                case 0x1102B: // MA
                    b += getUnicodeChar(0x92E);
                    i++;
                    break;
                case 0x1102C: // YA
                    b += getUnicodeChar(0x92F);
                    i++;
                    break;
                case 0x1102D: // RA
                    b += getUnicodeChar(0x930);
                    i++;
                    break;
                case 0x1102E: // LA
                    b += getUnicodeChar(0x932);
                    i++;
                    break;
                case 0x11034: // LLA
                    b += getUnicodeChar(0x933);
                    i++;
                    break;
                case 0x1102F: // VA
                    b += getUnicodeChar(0x935);
                    i++;
                    break;
                case 0x11030: // SHA
                    b += getUnicodeChar(0x936);
                    i++;
                    break;
                case 0x11031: // SSA
                    b += getUnicodeChar(0x937);
                    i++;
                    break;
                case 0x11032: // SA
                    b += getUnicodeChar(0x938);
                    i++;
                    break;
                case 0x11033: // HA
                    b += getUnicodeChar(0x939);
                    i++;
                    break;
                case 0x11038: // AA
                    b += getUnicodeChar(0x93E);
                    i++;
                    break;
                case 0x1103A: // I
                    b += getUnicodeChar(0x93F);
                    i++;
                    break;
                case 0x1103B: // II
                    b += getUnicodeChar(0x940);
                    i++;
                    break;
                case 0x1103C: // U
                    b += getUnicodeChar(0x941);
                    i++;
                    break;
                case 0x1103D: //UU
                    b += getUnicodeChar(0x942);
                    i++;
                    break;
                case 0x1103E: //R
                    b += getUnicodeChar(0x943);
                    i++;
                    break;
                case 0x1103F: //RR
                    b += getUnicodeChar(0x944);
                    i++;
                    break;
                case 0x11040: //L
                    b += getUnicodeChar(0x962);
                    i++;
                    break;
                case 0x11041: //LL
                    b += getUnicodeChar(0x963);
                    i++;
                    break;
                case 0x11042: //E
                    b += getUnicodeChar(0x947);
                    i++;
                    break;
                case 0x11043: //AI
                    b += getUnicodeChar(0x948);
                    i++;
                    break;
                case 0x11044: //O
                    b += getUnicodeChar(0x94B);
                    i++;
                    break;
                case 0x11045: //AU
                    b += getUnicodeChar(0x94C);
                    i++;
                    break;
                case 0x11046: //virama
                    b += getUnicodeChar(0x94D);
                    i++;
                    break;
                case 0x11047: // danda
                    b += getUnicodeChar(0x964);
                    i++;
                    break;
                case 0x11048: // double danda
                    b += getUnicodeChar(0x965);
                    i++;
                    break;
                case 0x11066: //0
                    b += getUnicodeChar(0x966);
                    i++;
                    break;
                case 0x11067: //1
                    b += getUnicodeChar(0x967);
                    i++;
                    break;
                case 0x11068: //2
                    b += getUnicodeChar(0x968);
                    i++;
                    break;
                case 0x11069: //3
                    b += getUnicodeChar(0x969);
                    i++;
                    break;
                case 0x1106A: //4
                    b += getUnicodeChar(0x96A);
                    i++;
                    break;
                case 0x1106B: //5
                    b += getUnicodeChar(0x96B);
                    i++;
                    break;
                case 0x1106C: //6
                    b += getUnicodeChar(0x96C);
                    i++;
                    break;
                case 0x1106D: //7
                    b += getUnicodeChar(0x96D);
                    i++;
                    break;
                case 0x1106E: //8
                    b += getUnicodeChar(0x96E);
                    i++;
                    break;
                case 0x1106F: //9
                    b += getUnicodeChar(0x96F);
                    i++;
                    break;
                default:
//                    c = new String(new int[]{n}, 0,1);
//                    c = "?";
//                    Log.d("c",c);
                    b += getUnicodeChar(n);
                    break;
            }
        }
        return b;
    }

    private String getUnicodeChar(int unicode) {
        return new String(Character.toChars(unicode));
    }
}
