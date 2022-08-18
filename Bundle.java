import java.util.HashMap;
import java.lang.Math;

public class Bundle { 

    static String learnModeAlgorithm(Question[] bundleQuestions, QuestionResponse[] bundleResponses) { 
        // a map with: keys corresponding the question id's, values corresponding to how many times student got it right 
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
            // get the question id corresponding to the (or one of the) smallest values. 
            String minId = null; 
            Integer minValue = null; 
            int incomplete = 0; // the number of incomplete questions 
            
            for (HashMap.Entry<String, Integer> entry : allMarks.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                // a question is considered incomplete if student got it right less than 2 times
                if (value < 2) { 
                    incomplete++; 
                }
                if (minValue == null || minValue > value) { 
                    minValue = value; 
                    minId = key; 
                }
            }
            // if min is 2, this means all questions have been completed, return null
            if (minValue == 2) { 
                return null; 
            }

            // if there is only 1 incomplete question left, then return this question id
            if (incomplete == 1) { 
                return minId; 
            }

            // if the question was shown recently (if in the 2nd half of bundleResponses array), increase its map value by 1 and go back to start of while-loop
            boolean shownRecently = false; 
            for (int i = Math.round(bundleResponses.length / 2); i < bundleResponses.length; i++) {
                if (bundleResponses[i].questionId.equals(minId)) { 
                    allMarks.put(minId, allMarks.get(minId) + 1); 
                    shownRecently = true; 
                    break; 
                }
            }

            // all else, return this id 
            if (!shownRecently) { 
                return minId; 
            }
        }

}

    public static void main(String[] args) { 
    }
}