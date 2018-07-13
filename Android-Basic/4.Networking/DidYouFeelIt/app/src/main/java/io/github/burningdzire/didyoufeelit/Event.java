package io.github.burningdzire.didyoufeelit;

public class Event {
    public final String title;
    public final String perceivedStrength;
    public final String numberOfPeople;

    public Event(String eventTitle, String eventPerceivedStrength, String eventNumberOfPeople)
    {
        this.title = eventTitle;
        this.perceivedStrength = eventPerceivedStrength;
        this.numberOfPeople = eventNumberOfPeople;
    }
}
