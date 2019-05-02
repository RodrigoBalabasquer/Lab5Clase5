package com.example.alumno.clase5;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 25/04/2019.
 */

public class ParseXml {

    public static List<PersonaModel> parseXml(String listaPersona) {
        List<PersonaModel> ListaPer = new ArrayList<>();
        XmlPullParser xml = Xml.newPullParser();

        try {
            xml.setInput(new StringReader(listaPersona));

            int event = xml.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.START_TAG) {
                    if("Persona".equals(xml.getName()))//obtenemos el nombre del tag sobre el cual estamos parado
                    {
                        PersonaModel p = new PersonaModel();
                        //xml.nextText() Obtenemos lo que esta entre los tag de apertura y cierre
                        String nombre = xml.getAttributeValue(null,"nombre");
                        String apellido = xml.getAttributeValue(null, "apellido");
                        String tel = xml.getAttributeValue(null,"tel");
                        p.setNombre(nombre);
                        p.setApellido(apellido);
                        p.setTelefono(tel);
                        p.setImagen(xml.nextText());
                        ListaPer.add(p);
                    }
                }

                event = xml.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  ListaPer;
    }

}
