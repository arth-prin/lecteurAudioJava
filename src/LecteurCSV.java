import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
                    nomF="./music/"+data;
                else
                    System.out.println("invalid data::" + data);
                index++;
            }
            index = 0;
            Morceau morceau = new Morceau(nomF,titre,album,nomA);
            System.out.println(morceau);
            morceaux.add(morceau);
        }

        //close reader
        reader.close();
    }

    public List<Morceau> getMorceaux(){
        return morceaux;
    }

    public void sortNomsMorceaux(){
        for(Morceau m : morceaux){
            System.out.println(m);
        }
        for(int i =0;i<morceaux.size();i++){
            Morceau tmp = morceaux.get(i);
            System.out.println(tmp);
            int index=i;
            for(int y=i+1;y<morceaux.size();y++){
                if(morceaux.get(y).nom.compareTo(tmp.nom)<0){
                    tmp = morceaux.get(y);
                    index=y;
                }
            }
            morceaux.set(index,morceaux.get(i));
            morceaux.set(i,tmp);
        }
    }

    public void sortNomsMorceauxR(){
        sortNomsMorceaux();
        Collections.reverse(morceaux);
    }

    public void sortNomsAlbum(){
        for(Morceau m : morceaux){
            System.out.println(m);
        }
        for(int i =0;i<morceaux.size();i++){
            Morceau tmp = morceaux.get(i);
            System.out.println(tmp);
            int index=i;
            for(int y=i+1;y<morceaux.size();y++){
                if(morceaux.get(y).album.compareTo(tmp.album)<0){
                    tmp = morceaux.get(y);
                    index=y;
                }
            }
            morceaux.set(index,morceaux.get(i));
            morceaux.set(i,tmp);
        }
    }

    public void sortNomsAlbumR(){
        sortNomsMorceaux();
        Collections.reverse(morceaux);
    }

    public void sortNomsAuteur(){
        for(Morceau m : morceaux){
            System.out.println(m);
        }
        for(int i =0;i<morceaux.size();i++){
            Morceau tmp = morceaux.get(i);
            System.out.println(tmp);
            int index=i;
            for(int y=i+1;y<morceaux.size();y++){
                if(morceaux.get(y).auteur.compareTo(tmp.auteur)<0){
                    tmp = morceaux.get(y);
                    index=y;
                }
            }
            morceaux.set(index,morceaux.get(i));
            morceaux.set(i,tmp);
        }
    }

    public void sortNomsAuteurR(){
        sortNomsMorceaux();
        Collections.reverse(morceaux);
    }
}

