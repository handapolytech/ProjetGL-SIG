package wtf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Test {
	public static String geHTMLSource(String url) throws IOException {
        URL yahoo = new URL(url);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        return a.toString();
    }
	
	public static void main(String[] args) throws IOException {
		
	/*	String htmlpage =Test.geHTMLSource("http://agreste.agriculture.gouv.fr/enquetes/industries-agroalimentaires-529/alimentation-animale-922/");
		 Pattern p = Pattern.compile("(<a href=)\"([^>].)*>\"");
	        Matcher m = p.matcher("kghgkjghg gjktkh "+htmlpage);
	        while(m.find()) {
	            System.out.println(m.group());
	        }*/
        String Meteo="load 'meteo.csv' as (omm:int, date, temperature:int, temps:int)";
		 Pattern pat = Pattern.compile("'[^']+'");
			Matcher mat1 = pat.matcher(Meteo.toString());
            pat = Pattern.compile("\\([^\\(]+\\)");
			 mat1 = pat.matcher(Meteo.toString());
      
			while(mat1.find())
			{
				String list =mat1.group().substring(1, mat1.group().length()-1);
				 System.out.println(list);

			}
			
	    /*
		String fileURL = "http://www.languedoc-roussillon.developpement-durable.gouv.fr/IMG/pdf/Barometre_SR_decembre_2014_cle13c769.pdf";
        String saveDir = "C:/GLtest";
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
	}
}