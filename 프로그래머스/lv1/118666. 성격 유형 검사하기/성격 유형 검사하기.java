class Solution {
    public String solution(String[] survey, int[] choices) {
        // R, T, C, F, J, M, A, N  - 0~7
        int[] arr = new int[8];
        for(int i=0; i<survey.length; i++){
            if(choices[i] == 4) continue;
            else if(choices[i] < 4){
                arr[getIndex(survey[i].charAt(0))] += 4 - choices[i];
            }
            else{
                arr[getIndex(survey[i].charAt(1))] += choices[i] - 4;
            }
        }
        String answer = "";
        if(arr[0]>=arr[1]) answer += "R"; else answer += "T";
        if(arr[2]>=arr[3]) answer += "C"; else answer += "F";
        if(arr[4]>=arr[5]) answer += "J"; else answer += "M";
        if(arr[6]>=arr[7]) answer += "A"; else answer += "N";
        return answer;
    }
    
    private int getIndex(Character c){
        switch (c){
            case 'R' : return 0;
            case 'T' : return 1;
            case 'C' : return 2;
            case 'F' : return 3;
            case 'J' : return 4;
            case 'M' : return 5;
            case 'A' : return 6;
            case 'N' : return 7;
        }
        return -1;
    }
}