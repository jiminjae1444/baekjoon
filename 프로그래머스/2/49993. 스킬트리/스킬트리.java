import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count=0;
        for (int j = 0; j < skill_trees.length; j++) {
            char[] ch = skill_trees[j].toCharArray();

            if (matchSkill(ch, skill)) {
                count++;
            }
        }
            return count;
    }
     public static boolean matchSkill(char [] ch,String skill){
        boolean flag = true;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if (skill.contains(String.valueOf(ch[i]))){
                list.add(String.valueOf(ch[i]));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.size()<skill.length()){
                skill=skill.substring(0, list.size());
                // System.out.println(skill);
            }
            char skillChar = skill.charAt(i);
            if (!list.get(i).equals(String.valueOf(skillChar))){
                flag=false;
                break;
            }
        }
        return flag;
    }
}