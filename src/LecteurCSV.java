import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LecteurCSV {

    private String fileName;
    private List<Morceau> morceaux = new ArrayList<>();

    public LecteurCSV(String fileName) throws IOException {
        this.fileName = fileName;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            String album="";
            String titre="";
            String nomA="";
            String nomF="";
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    album=data;
                else if (index == 1)
                    nomA=data;
                else if (index == 2)
                    titre=data;
                else if (index == 3)
                    nomF=data;
                else
                    System.out.println("invalid data::" + data);
                index++;
            }
            index = 0;
            Morceau morceau = new Morceau(nomF,titre);
            morceaux.add(morceau);
        }

        //close reader
        reader.close();
    }

    public List<Morceau> getMorceaux(){
        return morceaux;
    }

}

