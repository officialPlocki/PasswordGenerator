package xyz.plocki.passwordgenerator;

import xyz.plocki.passwordgenerator.utils.CreateCustomPassword;
import xyz.plocki.passwordgenerator.utils.CreatePassword;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class PasswordGenerator {

    public static void main(String[] args) throws IOException {
        boolean exist = false;
        File bat = new File("generatePassword.bat");
        if(!bat.exists()) {
            bat.createNewFile();
            FileWriter writer = new FileWriter(bat);
            writer.write("java -jar PasswordGenerator.jar");
            writer.close();
        } else {
            exist = true;
        }
        File sh = new File("generatePassword.sh");
        if(!sh.exists()) {
            sh.createNewFile();
            FileWriter writer = new FileWriter(sh);
            writer.write("java -jar PasswordGenerator.jar");
            writer.close();
        } else {
            exist = true;
        }
        if(exist) {
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\n\nPlease write now the security level of your password you wish to generate.\n\n");
                System.out.println("0  1  2  3  4  5  6  7  8  9  10  Custom\nLevel 10 is recommended. Custom mode is in beta (not recommended!)\nThe password will be saved to password.pw.plocki.\n\n");

                String text = br.readLine();

                if(text.equalsIgnoreCase("custom")) {
                    for(int i=0; i<150; i++) {
                        System.out.println("\n");
                    }

                    File file = new File("passwordGenerator.config");
                    if(!file.exists()) {
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write("Please set to \"true\" or \"false\".\n");
                        writer.write("\n");
                        writer.write("Length: 15\n");
                        writer.write("Special character: true\n");
                        writer.write("Numbers: true\n");
                        writer.write("Letters: true\n");
                        writer.close();
                        System.out.println("Please use the Custom.gen.plocki file, to customize your password.");
                        break;
                    } else {
                        BufferedReader br2 = new BufferedReader(new FileReader(file));
                        List<String> lines = br2.lines().collect(Collectors.toList());
                        int length = 0;
                        boolean special = false;
                        boolean numbers = false;
                        boolean letters = false;
                        for(String line : lines) {
                            if(line.contains("Length: ")) {
                                length = Integer.parseInt(line.replaceAll("Length: ", ""));
                            } else if(line.contains("Special character: ")) {
                                special = Boolean.getBoolean(line.replaceAll("Special character: ", ""));
                            } else if(line.contains("Numbers: ")) {
                                numbers = Boolean.getBoolean(line.replaceAll("Numbers: ", ""));
                            } else if(line.contains("Letters: ")) {
                                letters = Boolean.getBoolean(line.replaceAll("Letters: ", ""));
                            }
                        }
                        String password = new CreateCustomPassword(length, letters, numbers, special).build();
                        File pwfile = new File("password.pw");
                        if(pwfile.exists()) {
                            pwfile.delete();
                            pwfile.createNewFile();
                        } else {
                            pwfile.createNewFile();
                        }
                        FileUtils.writeStringToFile(pwfile, password, "UTF-8");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPASSWORD GENERATOR by plocki.\n\nYour password is: " + password + "\n\nThis password was by your custom configuration.\n\nPASSWORD GENERATOR by plocki.\n");
                        break;
                    }
                }

                String level = br.readLine();
                int levelInt = Integer.parseInt(level);
                if(levelInt >=0 && levelInt <=11 && levelInt != 11) {
                    String password = new CreatePassword(levelInt).build();
                    File file = new File("password.pw");
                    if(file.exists()) {
                        file.delete();
                        file.createNewFile();
                    } else {
                        file.createNewFile();
                    }
                    FileUtils.writeStringToFile(file, password, "UTF-8");
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPASSWORD GENERATOR by plocki.\n\nYour password is: " + password + "\n\nThis password was generated on level "+levelInt+".\n\nPASSWORD GENERATOR by plocki.\n");
                } else {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPassword can't be generated. Please restart the programm.");
                }
                System.out.println("Please copy the password. If it is not showing correctly, it was saved to password.pw.plocki.");
                break;
            }
        }
        System.out.println("Please use start.bat or start.sh.");
    }

}
