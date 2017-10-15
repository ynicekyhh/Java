package chapter03.tv;

public class TV {
	
	private int channel;
	private int volume;
	private boolean power;
	
	public TV( int channel, int volume, boolean power ) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public boolean isPower() {
		return power;
	}
	
	public void power( boolean on ) {
		power = on;
	}
	
	public void channel( int channel ) {
		if( power == false ) {
			return;
		}
		
		if( channel < 1 ) {
			channel = 255;
		} else if( channel > 255 ) {
			channel = 1;
		}
		
		this.channel = channel;
	}
	
	public void channel( boolean up ) {
		channel( channel + ( up ? 1 : -1 ) );
	}
	
	public void volume( int volume ) {
		if( power == false ) {
			return;
		}
		
		if( volume < 0 ) {
			volume = 0;
		} else if( volume > 100 ) {
			volume = 100;
		}
		
		this.volume = volume;
	}
	
	public void volume( boolean up ) {
		volume( volume + ( up ? 1 : -1 ) );
	}
	
	public void status() {
		
		System.out.println(
			"TV[channel=" + channel +
			", volume=" + volume +
			", power=" + power + "]" );
	}
}
