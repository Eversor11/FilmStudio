
package filmstudio.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileReader {
    
    public FileReader(){
    }
    
    public List<String> readFile(String path){
        
        File file = new File(path);
        List<String> lines = new ArrayList<String>();
        
        try{
            Scanner reader = new Scanner(file);
            
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }
            
            reader.close();
            
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        
        return lines;
    }

}
