package com.example.borja.aplicacionloteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    private Boleto[]datos;
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Boleto>arr=new ArrayList<Boleto>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            URL url = new URL("https://www.juegosonce.es/rss/sorteos2.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(url.openStream()));
         //   Document doc = db.parse(new FileInputStream(new File("C://Users//Borja//Desktop//xx.xml")));
            doc.getDocumentElement().normalize();

            NodeList nodeList1 = doc.getElementsByTagName("item");//todosItems
             Log.e("Tamaño de la list",String.valueOf(nodeList1.getLength()));
            for(int i=0;i<nodeList1.getLength();i++){
                Element node =(Element) nodeList1.item(i);//cadaItem
                arr.add(new Boleto(node.getElementsByTagName("numero").item(0).getTextContent(),
                                            node.getElementsByTagName("serie").item(0).getTextContent(),
                                            node.getElementsByTagName("tipo").item(0).getTextContent()));
                Log.e("Error",node.getElementsByTagName("numero").item(0).getTextContent());
            }


        }catch (Exception e){
            e.printStackTrace();
            Log.e("Error", "No entra al try");
        }
        datos=new Boleto[arr.size()];
        for(int i=0;i<arr.size();i++)
            datos[i]=arr.get(i);
        /*datos=new Boleto[]{new Boleto("99999","012","Diario 1"),
                           new Boleto("88888","112","Diario 2"),
                           new Boleto("77777","212","Diario 3"),
                           new Boleto("66666","099","Diario 4"),
                           new Boleto("55555","001","Diario 5"),
                           new Boleto("34567","005","Diario 6"),
                           new Boleto("87654","045","Diario 7"),
                           new Boleto("23473","071","Diario 8"),
                           new Boleto("83682","091","Diario 9"),
                           new Boleto("06856","231","Diario 10")};*/
        //rellenamos el adaptador
        AdaptadorListview adaptador=new AdaptadorListview(this,datos);
        lista=(ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);
    }
}
