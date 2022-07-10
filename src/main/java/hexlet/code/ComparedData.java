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


/*        public List<KeyDifference> generateListOfComparedobjects(Map<String, Object> firstMap, Map<String, Object> secondMap) {
            List<KeyDifference> result = new ArrayList<>();

            for (String key : firstMap.keySet()) {
                ComparedData.KeyDifference tmp = new ComparedData.KeyDifference();
                tmp.setKeyValue(key);
                tmp.setInFirstJson(true);
                tmp.setFirstValue(String.valueOf(firstMap.get(key)));
                if (secondMap.containsKey(key)) {
                    tmp.setInSecondJson(true);
                    tmp.setSecondValue(String.valueOf(secondMap.get(key)));
                }
                result.add(tmp);
            }

            for (String key : secondMap.keySet()) {
                if (!firstMap.containsKey(key)) {
                    ComparedData.KeyDifference tempObj = new ComparedData.KeyDifference();
                    tempObj.setKeyValue(key);
                    tempObj.setInSecondJson(true);
                    tempObj.setSecondValue(String.valueOf(secondMap.get(key)));
                    result.add(tempObj);
                }
            }

            result.sort(Comparator.comparing(ComparedData.KeyDifference::getKeyValue));
            return result;

        }*/
    }
}
