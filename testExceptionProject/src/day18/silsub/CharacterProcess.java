package day18.silsub;

public class CharacterProcess {
	public CharacterProcess() {}
	public int countAlpha(String s) throws CharCheckException{
		int count=0;
		for (int i=0; i<s.length(); i++){
			if (s.toUpperCase().charAt(i)>='A' && s.toUpperCase().charAt(i)<='Z'){
				count++;
			}
			if (s.charAt(i)==' '){
				throw new CharCheckException("공백이 포함되었습니다.");
			}
		}
		return count;
	}
	
}
