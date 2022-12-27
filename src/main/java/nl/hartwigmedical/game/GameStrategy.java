package nl.hartwigmedical.game;

/***
 * Strategy interface so the game could be enhanced with other strategies
 */
public interface GameStrategy {
    public Choice applyStrategy();
}
