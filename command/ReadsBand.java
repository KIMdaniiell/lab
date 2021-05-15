package command;
import data.format.*;
import exceptions.InvalidInputValueException;
import java.time.Month;
import java.util.Scanner;
import java.time.DateTimeException;
import java.util.Stack;

/**
 * This class is necessary for Commands receiving new instances of MusicBand class
 */
public class ReadsBand {

    /**
     * Method receives new instance of MusicBand class
     * @param stack - main collection (Stack<MusicBand>)
     * @return new instance of MusicBand class
     */
    public MusicBand addition(Stack<MusicBand> stack){
        MusicBand band = new MusicBand();
        Scanner sc = new Scanner(System.in);

        Idsetter(sc,band,stack);
        Namesetter(sc,band);
        Coordinatessetter(sc,band);
        NumberOfParticipantssetter(sc,band);
        Descriptionsetter(sc,band);
        EstablishmentDatesetter(sc,band);
        Genresetter(sc,band);
        Personsetter(sc,band);

        return band;
    }

    private void Idsetter (Scanner sc, MusicBand band, Stack<MusicBand> mystack){
        band.setId(mystack);
    }
    private void Namesetter (Scanner sc, MusicBand band){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле Name :\t");
                String st = sc.nextLine();
                band.setName(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void Coordinatessetter (Scanner sc, MusicBand band){
        Coordinates coord = new Coordinates();
        Xsetter(sc,coord);
        Ysetter(sc,coord);
        band.setCoordinates(coord);
    }
    private void Xsetter (Scanner sc, Coordinates c){
        boolean input_is_correct = false;
        while (!input_is_correct) {
            try {
                System.out.print("\nВведите поле Coordinates.X :\t");
                String st = sc.nextLine();
                c.setX(st);
                input_is_correct = true;
            } catch (NumberFormatException e) {
                System.out.println("Недопустимое значение Coordinates.X . Невозможно привести к типу long.");
            }
        }
    }
    private void Ysetter (Scanner sc, Coordinates c){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле Coordinates.Y :\t");
                String st = sc.nextLine();
                c.setY(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Недопустимое значение Coordinates.Y . Невозможно привести к типу Double.");
            }
        }

    }

    private void NumberOfParticipantssetter (Scanner sc, MusicBand band){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле numberOfParticipants :\t");
                String st = sc.nextLine();
                band.setNumberOfParticipants(st);
                input_is_correct = true;
            } catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Недопустимое значение NumberOfParticipants. Невозможно привести к типу Integer.");
            }
        }

    }
    private void Descriptionsetter (Scanner sc, MusicBand band){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле description :\t");
                String st = sc.nextLine();
                band.setDescription(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private void EstablishmentDatesetter (Scanner sc, MusicBand band){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле establishmentDate :\t");
                String st = sc.nextLine();
                band.setEstablishmentDate(st);
                input_is_correct = true;
            }catch (NumberFormatException e){
                System.out.println("Недопустимое значение EstablishmentDate. Невозможно привести к типу java.util.Date .");
            }
        }

    }
    private void Genresetter (Scanner sc, MusicBand band){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.println("\nВведите поле Genre :\t");
                System.out.print("{\t");
                for (MusicGenre genre: MusicGenre.values()){
                    System.out.print(genre+"\t");
                }
                System.out.print("} : \t");
                String st = sc.nextLine();
                band.setGenre(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private void Personsetter (Scanner sc,MusicBand band){
        Person p = new Person();
        System.out.println("\nВведите поле Person (пустую строку, если person = null)");
        if (!sc.nextLine().equals("")) {
            FNamesetter(sc, p);
            FPassportIDsetter(sc, p);
            FEyeColorsetter(sc, p);
            FLocSetter(sc,p);
            band.setFrontMan(p);
        }else{
            band.setFrontMan("");
        }
    }
    private void FNamesetter (Scanner sc, Person p){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле Frontman.Name :\t");
                String st = sc.nextLine();
                p.setName(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }
        }

    }
    private void FPassportIDsetter (Scanner sc, Person p){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле Frontman.PassportID :\t");
                String st = sc.nextLine();
                p.setPassportID(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }
        }

    }
    private void FEyeColorsetter (Scanner sc, Person p){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try {
                System.out.print("\nВведите поле Frontman.EyeColor :\t");
                for (Color c: Color.values()){
                    System.out.print(c+"\t");
                }
                String st = sc.nextLine();
                p.setEyeColor(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private void FLocSetter (Scanner sc, Person p){
        Location l = new Location();
        FrLocXsetter(sc, l);
        FrLocYsetter(sc, l);
        FrLocZsetter(sc, l);
        p.setLocation(l);
    }
    private void FrLocXsetter (Scanner sc, Location l){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try{
                System.out.print("\nВведите поле Frontman.Location.X :\t");
                String st = sc.nextLine();
                l.setX(st);
                input_is_correct = true;
            } catch (InvalidInputValueException e ){
                System.out.println(e.getMessage());
            } catch (NumberFormatException e ){
                System.out.println("Недопустимое значение Person.Location.X . Невозможно привести к типу Integer .");
            }
        }

    }
    private void FrLocYsetter (Scanner sc, Location l){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try{
                System.out.print("\nВведите поле Frontman.Location.Y :\t");
                String st = sc.nextLine();
                l.setY(st);
                input_is_correct = true;
            }catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            } catch (NumberFormatException e ){
                System.out.println("Недопустимое значение Person.Location.Y . Невозможно привести к типу int .");
            }
        }

    }
    private void FrLocZsetter (Scanner sc, Location l){
        boolean input_is_correct = false;
        while (!input_is_correct){
            try{
                System.out.print("\nВведите поле Frontman.Location.Z :\t");
                String st = sc.nextLine();
                l.setZ(st);
                input_is_correct = true;
            } catch (InvalidInputValueException e){
                System.out.println(e.getMessage());
            } catch (NumberFormatException e ) {
                System.out.println("Недопустимое значение Person.Location.Z . Невозможно привести к типу int .");
            }
        }

    }



}