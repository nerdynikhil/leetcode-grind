class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree= new int[n+1];
        int[] outDegree= new int[n+1];

        for (int[] currentTrust: trust){
            outDegree[currentTrust[0]] +=1;
            inDegree[currentTrust[1]] +=1;
        }

        for (int currentPerson = 1;currentPerson <=n; currentPerson++){
            if (outDegree[currentPerson] == 0 && inDegree[currentPerson] == n-1){
                return currentPerson;
            }
        }

        return -1;
    }
}