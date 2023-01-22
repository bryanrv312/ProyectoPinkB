package Control_BD;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;



public class createPdf {

    private Font funteTitulo= new Font (Font.FontFamily.COURIER,25,Font.BOLDITALIC);
    private Font fuenteBold= new Font (Font.FontFamily.COURIER,18,Font.BOLD);
    private Font fuenteExtra= new Font (Font.FontFamily.COURIER,15,Font.BOLD);
    
    
//    public void pdf(String header,String info,String footer,String rutaimagen,String salida){
//        try {
//            Document document=new Document(PageSize.A4,36,36,10,10);
//            PdfWriter.getInstance(document,new FileOutputStream(salida));
//            document.open();
//            document.add(getHeader(header));
//            Image imagen= Image.getInstance(rutaimagen);
//            imagen.scaleAbsolute(100,100);
//            imagen.setAlignment(Element.ALIGN_CENTER);
//            document.add(imagen);
//            document.add(getInfo(info));
//            document.add(getFooter(footer));
//            document.close();
//        } catch (Exception e) {
//        }
//    }
    
    public Paragraph getcabezera(String texto)
    {
        Paragraph p=new Paragraph();
        Chunk c= new Chunk();
        c.append(texto);
        c.setFont(funteTitulo);
        
        p.add(c);
        return p;
    }

  
    public Paragraph getContenido(String texto)
    {
        Paragraph p=new Paragraph();
        Chunk c= new Chunk();
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }    
        public Paragraph getUltimo(String texto)
    {
        Paragraph p=new Paragraph();
        Chunk c= new Chunk();
        c.append(texto);
        c.setFont(fuenteExtra);
        p.add(c);
        return p;
    }    
        
        public Image getBarcode(Document document,PdfWriter pw, String codigo)
        {
            PdfContentByte cimg= pw.getDirectContent();
            Barcode128 code128=new Barcode128();
            code128.setCode(formatearCodigo(codigo));
            code128.setCodeType(Barcode128.CODE128);
            code128.setTextAlignment(Element.ALIGN_CENTER);
            
            Image image=code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
            float scaler =((document.getPageSize().getWidth()-document.leftMargin()-document.rightMargin()-0)/image.getWidth()*20);
            image.scalePercent(scaler);
            image.setAbsolutePosition(70f, 170f);;
            return image;
        }
        
        public String formatearCodigo(String num)
        {
            NumberFormat form=new DecimalFormat("00000000000");
            return form.format((num != null)? Long.parseLong(num):000000000000);
        }

}
