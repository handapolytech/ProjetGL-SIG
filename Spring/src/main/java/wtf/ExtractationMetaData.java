package wtf;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class ExtractationMetaData
{
    public static void main( String[] args )
    {
      /*  if( args.length == 0 )
        {
            System.out.println( "Usage: Test <image-file>" );
            System.exit( 0 );
        }*/
        
        String filename = "/C:/Users/Eric/Downloads/20140825_095807.jpg";
        System.out.println( "Filename: " + filename );
        Path path1 = Paths.get("/Users/Eric/Downloads","2.pdf");
        //Path.get(URI.create("file:///Users/joe/FileTest.java"));
 
        	BasicFileAttributes basicAttributes;
			try {
				basicAttributes = Files.readAttributes(path1, BasicFileAttributes.class);
				System.out.println("Creation Time: "+basicAttributes.creationTime());
	        	System.out.println("Directory? "+basicAttributes.isDirectory());
	        	System.out.println("File? "+basicAttributes.isRegularFile());
	        	System.out.println("Last accessed on: "+basicAttributes.lastAccessTime());
	        	System.out.println("Last modified on: "+basicAttributes.lastModifiedTime());
	        	System.out.println("File size: "+basicAttributes.size()+"bytes");
	        	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
        	
       /* try
        {
           
        	File jpgFile = new File( filename );
            Metadata metadata = MetadataReader.readMetadata( jpgFile );

            // Read Exif Data
            Directory directory = metadata.getDirectory( ExifDirectory.class );
            if( directory != null )
            {
                // Read the date
                Date date = directory.getDate( ExifDirectory.TAG_DATETIME );
                DateFormat df = DateFormat.getDateInstance();
                df.format( date );
                int year = df.getCalendar().get( Calendar.YEAR );
                int month = df.getCalendar().get( Calendar.MONTH ) + 1;

                System.out.println( "Year: " + year + ", Month: " + month );

                System.out.println( "Date: " + date );

                System.out.println( "Tags" );
                for(Iterator i = directory.getTagIterator(); i.hasNext(); )
                {
                    Tag tag = ( Tag )i.next();
                    System.out.println( "\t" + tag.getTagName() + " = " + tag.getDescription() );

                }
            }
            else
            {
                System.out.println( "EXIF is null" );
            }
	
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }*/
                
    }
}
