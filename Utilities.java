    /**
     * En hjelpeklasse for statiske metoder
     * Created by Robin Hextall-Schjelderup on 23.10.2016.
     */
    public class Utilities {

        /**
         * Metode for å rense et negativ til til 0
         * @param value et tall
         * @return 0 hvis value < 0, hvis ikke tallet selv
         */
        public static int cleanNegative(int value) {
            if(value < 0) {
                return 0;
            }
            return value;
        }

        /**
         * Metode for å sjekke at en string ikke er tom.
         * @param string stringen vi vil sjekke
         * @return unspecified hvis stringen er tom, hvis ikke verdien til stringen.
         */
        public static String checkString(String string) {
            if(string.isEmpty()) {
                return "Unspecified";
            } else {
                return string;
            }

//            Annen måte å gjøre det på er...
//            return !string.equals("") ? string : "Unspecified";

        }
    }
