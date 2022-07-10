package hexlet.code;


public class ComparedData {
    static class KeyDifference {
        private String keyValue = "";
        private String firstValue = "";
        private String secondValue = "";
        private boolean isInFirstJson = false;
        private boolean isInSecondJson = false;

        public String getKeyValue() {
            return keyValue;
        }

        public void setKeyValue(String keyValue) {
            this.keyValue = keyValue;
        }

        public String getFirstValue() {
            return firstValue;
        }

        public void setFirstValue(String firstValue) {
            this.firstValue = firstValue;
        }

        public String getSecondValue() {
            return secondValue;
        }

        public void setSecondValue(String secondValue) {
            this.secondValue = secondValue;
        }

        public boolean isInFirstJson() {
            return isInFirstJson;
        }

        public void setInFirstJson(boolean inFirstJson) {
            isInFirstJson = inFirstJson;
        }

        public boolean isInSecondJson() {
            return isInSecondJson;
        }

        public void setInSecondJson(boolean inSecondJson) {
            isInSecondJson = inSecondJson;
        }


        public String formatter() {
            String result = "";
            if (isInFirstJson && isInSecondJson) {
                if (!firstValue.equals(secondValue)) {
                    result = result + "- " + keyValue + ": " + firstValue + "\n  ";
                    result = result + "+ " + keyValue + ": " + secondValue + "\n  ";
                } else {
                    result = result + "  " + keyValue + ": " + firstValue + "\n  ";
                }
            } else if (isInFirstJson) {
                result = result + "- " + keyValue + ": " + firstValue + "\n  ";
            } else if (isInSecondJson) {
                result = result + "+ " + keyValue + ": " + secondValue + "\n  ";
            }
            return result;
        }
    }
}
