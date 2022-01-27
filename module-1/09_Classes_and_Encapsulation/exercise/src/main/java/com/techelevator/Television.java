package com.techelevator;

public class Television {

    /*


        How to Build a TV (Constructor)
            default constructor


        TV Power
            See if the is on isOn()
            turn off - turnOff()
            turn on - turnOn(): always reset channel to 3 and volume to 2
            track: boolean isOn
            Starts: off


        Channel
            track: int currentChannel
            see channel getCurrentChannel()
            always between 3 - 18
            change to specific channel changeChannel(int newChannel)
            go up 1 channel (channelUp())
            go down 1 channel (channelDown())
            Starts at 3
            if goes > 18 rolls over to 3
            if goes < 3 rolls over to 18


        Volume
            track: int currentVolume
            see volume getCurrentVolume()
            always between 0 - 10
            go up 1 volume: raiseVolume()
            go down 1 volume: lowerVolume()
            Starts at 2
     */


    /*
        Member variables
        ALWAYS PRIVATE
     */
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    /*
        GETTERS AND SETTERS
        Provide public access to the private member variables (Encapsulation)
     */
    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    /*
        METHODS
     */

    public void turnOff() {
        isOn = false;
    }
    public void turnOn() {
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void changeChannel(int newChannel) {
        if (isOn && (newChannel >= 3 && newChannel <= 18)) {
            currentChannel = newChannel;
        }
    }
    public void channelUp() {
        if (isOn) {
            currentChannel++;
        }
        if (currentChannel > 18) {
            currentChannel = 3;
        }
    }
    public void channelDown(){
        if (isOn) {
            currentChannel--;
        }
        if (currentChannel < 3) {
            currentChannel = 18;
        }
    }
    public void raiseVolume() {
        if (isOn && currentVolume <= 9) {
            currentVolume++;
        }
    }
    public void lowerVolume() {
        if (isOn && currentVolume >= 1) {
            currentVolume--;
        }
    }
}
