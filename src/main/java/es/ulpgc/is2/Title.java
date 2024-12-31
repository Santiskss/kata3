package es.ulpgc.is2;

public record Title(String id, Title.TitleType titleType, String primaryTitle) {
    public enum TitleType{
        VideoGame,
        TvPilot,
        Movie,
        TvSeries,
        TvMiniSeries,
        Short,
        TvSpecial,
        TvShort,
        Video,
        TvMovie,
        TvEpisode
    }
}
