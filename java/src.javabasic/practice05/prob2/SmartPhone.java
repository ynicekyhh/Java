package practice05.prob2;

public class SmartPhone extends MusicPhone {
	@Override
	public void execute(String function) {
		if(function.equals("앱")) {
			executeApp();
		}else if(function.equals("음악")) {
			playMusic();
		}else {
			super.execute(function);
		}
	}
	
	protected void executeApp() {
		System.out.println("앱실행");
	}
	
	@Override
	protected void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
}
