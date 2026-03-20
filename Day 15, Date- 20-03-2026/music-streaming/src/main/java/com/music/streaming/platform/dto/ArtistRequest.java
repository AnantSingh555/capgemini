package com.music.streaming.platform.dto;

import lombok.Getter;
import lombok.Setter;


public record ArtistRequest(String artistName,
                            String bio,
                            String genre,
                            String origin,
                            String formedYear,
                            String socialLink,
                            String image
) {

}
