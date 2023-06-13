package designpattern.Behaviuorpattrn;


interface IState {
    void traficSignalLightSwitchOn(TraficSignalLightSwitch lightSwitch);
    void traficSignalLightSwitchOff(TraficSignalLightSwitch lightSwitch);
}

class TraficSignalLightSwitch {
    private IState state;
    
    public TraficSignalLightSwitch() {
        state = new RedTrafficLightState();
    }
    
    public void setState(IState state) {
        this.state = state;
    }
    
    public void traficSignalLightSwitchOn() {
        state.traficSignalLightSwitchOn(this);
    }
    
    public void traficSignalLightSwitchOff() {
        state.traficSignalLightSwitchOff(this);
    }
}

class RedTrafficLightState implements IState {
    @Override
    public void traficSignalLightSwitchOn(TraficSignalLightSwitch lightSwitch) {
        System.out.println("Red Signal on");
    }
    
    @Override
    public void traficSignalLightSwitchOff(TraficSignalLightSwitch lightSwitch) {
        System.out.println("Red Signal off");
        lightSwitch.setState(new GreenTrafficLightState());
    }
}

class GreenTrafficLightState implements IState {
    @Override
    public void traficSignalLightSwitchOn(TraficSignalLightSwitch lightSwitch) {
        System.out.println("Green Signal on");
        lightSwitch.setState(new GreenTrafficLightState());
    }
    
    @Override
    public void traficSignalLightSwitchOff(TraficSignalLightSwitch lightSwitch) {
        System.out.println("Green Signal off");
    }
}


public class StateExample {
    public static void main(String[] args) {
    	TraficSignalLightSwitch lightSwitch = new TraficSignalLightSwitch();
        lightSwitch.traficSignalLightSwitchOn();
        lightSwitch.traficSignalLightSwitchOff();
        lightSwitch.traficSignalLightSwitchOn();
        lightSwitch.traficSignalLightSwitchOff();
    }
}
