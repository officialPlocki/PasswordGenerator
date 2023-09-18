package xyz.plocki.passwordgenerator.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreatePassword {

    private String password;

    public CreatePassword(int safetyLevel) {
        if(safetyLevel==0) {
            String upper = RandomStringUtils.random(3, 3, 69, true, true);
            String lower = RandomStringUtils.random(2, 9, 69, true, true);
            String numbers = RandomStringUtils.randomNumeric(2);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==1) {
            String upper = RandomStringUtils.random(1, 3, 69, false, true);
            String lower = RandomStringUtils.random(1, 4, 69, true, false);
            String numbers = RandomStringUtils.randomNumeric(5);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==2) {
            String upper = RandomStringUtils.random(4, 3, 69, true, true);
            String lower = RandomStringUtils.random(2, 2, 119, true, true);
            String numbers = RandomStringUtils.randomNumeric(7);
            String specialChar = RandomStringUtils.random(3, 3, 69, true, true);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==3) {
            String upper = RandomStringUtils.random(2, 3, 69, true, true);
            String lower = RandomStringUtils.random(2, 4, 114, true, true);
            String numbers = RandomStringUtils.randomNumeric(4);
            String specialChar = RandomStringUtils.random(3, 3, 69, true, true);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==4) {
            String upper = RandomStringUtils.random(4, 3, 69, false, true);
            String lower = RandomStringUtils.random(4, 4, 69, true, true);
            String numbers = RandomStringUtils.randomNumeric(9);
            String specialChar = RandomStringUtils.random(3, 3, 47, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==5) {
            String upper = RandomStringUtils.random(3, 3, 80, true, true);
            String lower = RandomStringUtils.random(3, 9, 80, true, true);
            String numbers = RandomStringUtils.randomNumeric(5);
            String specialChar = RandomStringUtils.random(3, 4, 33, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(4);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==6) {

            String upper = RandomStringUtils.random(6, 3, 80, true, true);
            String lower = RandomStringUtils.random(6, 9, 80, true, true);
            String numbers = RandomStringUtils.randomNumeric(2);
            String specialChar = RandomStringUtils.random(3, 1, 15, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==7) {
            String upper = RandomStringUtils.random(2, 3, 80, true, true);
            String lower = RandomStringUtils.random(2, 4, 80, true, true);
            String numbers = RandomStringUtils.randomNumeric(5);
            String specialChar = RandomStringUtils.random(3, 14, 47, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==8) {

            String upper = RandomStringUtils.random(5, 3, 80, true, true);
            String lower = RandomStringUtils.random(5, 19, 80, true, true);
            String numbers = RandomStringUtils.randomNumeric(9);
            String specialChar = RandomStringUtils.random(3, 3, 47, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==9) {

            String upper = RandomStringUtils.random(7, 3, 80, true, true);
            String lower = RandomStringUtils.random(7, 2, 80, true, true);
            String numbers = RandomStringUtils.randomNumeric(1);
            String specialChar = RandomStringUtils.random(3, 23, 47, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        } else if(safetyLevel==10) {
            String upper = RandomStringUtils.random(20, 31, 541, true, true);
            String lower = RandomStringUtils.random(20, 122, 154, true, true);
            String numbers = RandomStringUtils.randomNumeric(10);
            String specialChar = RandomStringUtils.random(3, 323, 479, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(8);
            String combinedChars = upper.concat(lower)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            this.password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        }

    }

    public String build() {
        return password;
    }

}
