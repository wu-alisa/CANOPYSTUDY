import java.util.HashMap;

public class Bundle { 

    static String learnModeAlgorithm(Question[] bundleQuestions, QuestionResponse[] bundleResponses) { 
        // a map with keys corresponding the question id's and how many times student got it right 
        HashMap<String, Integer> allMarks = new HashMap<String, Integer>();
        for (Question q: bundleQuestions) { 
            allMarks.put(q.id, 0);
        }

        // loop through all responses in order. Update map values if correct. 
        for (QuestionResponse r: bundleResponses) { 
            if (r.isCorrect) { 
                allMarks.put(r.questionId, allMarks.get(r.questionId) + 1); 
            }
        }

        while (true) { 
            // get the question id corresnponding to the (or one of the) smallest values. 
            String minId = null; 
            Integer minValue = null; 
            for (HashMap.Entry<String, Integer> entry : allMarks.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (minValue == null || minValue > value) { 
                    minValue = value; 
                    minId = key; 
                }
            }
            // if min is 2, return null
            if (minValue == 2) { 
                return null; 
            }

            // if all other questions have reached 2 points, then return this question id

            // if the question was shown once already in the 2nd half of bundleResponses array, add 1 value to it and continue 

            // all else, return this id 
        }

}

    public static void main(String[] args) { 
        // clarify that bundleResponses is in onder (index 0 is oldest answer, last index is most recent answer )
    }
}