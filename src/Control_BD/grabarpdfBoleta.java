/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import Control_BD.createPdf;
import Control_BD.productos;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 * private String sSQL = "";
 */

public class grabarpdfBoleta {
 
    
   
    private createPdf pdf;
    private String titulo = "PINKBERRY (DELOSI S.A.)";
    private String numeroruc = "20100123330";
    private String nomE = "NOMBRE DEL CLIENTE:";
    private String rucE = "DNI:";
    private String dirE = "Direccion:";
    private List<productos> lstProd;
    private String txtEmpresa;
    private String txtruc;
    private String txtDir;
    private float total;
    private String nroBoletas;
   

    public grabarpdfBoleta(List<productos> lst, String nombreE, String rucEmpre, String direcEmpr, float precio,String nroBoleta) {
        pdf = new createPdf();
        lstProd = lst;
        txtEmpresa = nombreE;
        txtruc = rucEmpre;
        txtDir = direcEmpr;
        total = precio;
        nroBoletas= nroBoleta;
    }

    public void grabarPdf() {
         String selectSQL;
        Calendar fecha = Calendar.getInstance();

        //String nombrePdf = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + String.valueOf(fecha.get(Calendar.MONTH)) + String.valueOf(fecha.get(Calendar.YEAR)) + "_" + String.valueOf(fecha.get(Calendar.HOUR)) + String.valueOf(fecha.get(Calendar.MINUTE)) + String.valueOf(fecha.get(Calendar.SECOND));
      // String fechaNac = fecha.get(Calendar.YEAR) + "/" + ((fecha.get(Calendar.MONTH))+1)%12 + "/" + fecha.get(Calendar.DAY_OF_MONTH);
      String fechaNac = fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH) + "/"  + "/" + fecha.get(Calendar.YEAR);  
      System.out.println(nroBoletas);
        String path1 = "boletas\\" + nroBoletas + ".pdf";
        String path = "\\boletas\\" + nroBoletas + ".pdf";
        int msg = JOptionPane.showConfirmDialog(null, "Deseas Grabar el Registro", "Grabar", JOptionPane.YES_NO_OPTION);
        if (msg == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro Grabado Satisfactoriamente!!!");
            try {
                Document doc = new Document(PageSize.LETTER, 36, 36, 54, 36);
                FileOutputStream archivo = new FileOutputStream(path1);
                PdfWriter writer = PdfWriter.getInstance(doc, archivo);
                doc.open();
                Image imagen2 = Image.getInstance("src\\Icon\\story-pb_2.png");
                imagen2.scaleAbsolute(500, 500);
                imagen2.setAbsolutePosition(55f, 130f);
                doc.add(imagen2);
                Image imagen = Image.getInstance("src\\Icon\\story-pb_2.png");
                imagen.scaleAbsolute(100, 100);
                imagen.setAbsolutePosition(50f, 650f);
                doc.add(imagen);
                Image imagen1 = Image.getInstance("src\\Icon\\pingberry.png");
                imagen1.scaleAbsolute(100, 100);
                imagen1.setAbsolutePosition(470f, 650f);
                doc.add(imagen1);

                // pdf p= pdf.getcabezera(titulo.getText()+"\n"+numeroruc.getText()+"\n"+direccion.getText()).setAlignment(Element.ALIGN_JUSTIFIED);
                Paragraph p = pdf.getcabezera(titulo + "\n\n\n" + numeroruc);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);
                p = pdf.getContenido("\n\n\nFecha:" + fechaNac);
                p.setAlignment(Element.ALIGN_RIGHT);
                doc.add(p);
                p = pdf.getContenido("\n\n" + nomE + " " + txtEmpresa + "\n\n" + rucE + " " + txtruc + "\n\n" + dirE + " " + txtDir + "\n\n\n");
                p.setAlignment(Element.ALIGN_LEFT);
                doc.add(p);

                PdfPTable table = new PdfPTable(5);
                // addCell() agrega una celda a la tabla, el cambio de fila
                // ocurre automaticamente al llenar la fila
                table.setWidthPercentage(100);

                table.addCell("PRODUCTO");
                table.addCell("DESCRIPCION");
                table.addCell("PRECIO U.");
                table.addCell("CANTIDAD");
                table.addCell("TOTAL");

                for (int i = 0; i < lstProd.size(); i++) {
                    table.addCell(lstProd.get(i).getNombre());
                    table.addCell(lstProd.get(i).getDescripcion());
                    table.addCell(String.valueOf(lstProd.get(i).getPrecio()));
                    table.addCell(String.valueOf(lstProd.get(i).getCantidad()));
                    table.addCell(String.valueOf(lstProd.get(i).getPrecio() * lstProd.get(i).getCantidad()));
                }
                // Si desea crear una celda de mas de una columna
                // Cree un objecto Cell y cambie su propiedad span
                doc.add(table);
                String totalString = String.valueOf(total);
                String igvString = String.valueOf((18.00 * total) / 100);
                String SubtoString = String.valueOf(total - ((18.00 * total) / 100));
                p = pdf.getUltimo("\n\n" + "SUBTOTAL: s/" + SubtoString + "\n\n" + "IGV: s/" + igvString + "\n\n" + "TOTAL: s/" + totalString);
                p.setAlignment(Element.ALIGN_RIGHT);
                doc.add(p);

                doc.add(pdf.getBarcode(doc, writer, txtruc));

                Image imagen3 = Image.getInstance("src\\Icon\\pagado.jpg");
                imagen3.scaleAbsolute(100, 100);
                imagen3.setAbsolutePosition(470f, 170f);
                doc.add(imagen3);

                doc.close();
                JOptionPane.showMessageDialog(null, "Pdf correctamente creado");

                
                String master = System.getProperty("user.dir") + path;
                try {
                    File pathPdf = new File(master);
                    Desktop.getDesktop().open(pathPdf);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } catch (Exception e) {
                System.out.println("error: " + e);

            }
//            fact n = new fact(fa.getCorrelativoAcc(), getEmpresa(),, fechaNac, fechaNac);

        } else {

        }
    }

}
