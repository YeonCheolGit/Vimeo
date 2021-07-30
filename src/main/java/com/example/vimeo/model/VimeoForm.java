package com.example.vimeo.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VimeoForm {
    private String type;
    private String version;
    private String provider_name;
    private String provider_url;
    private String title;
    private String author_name;
    private String author_url;
    private String is_plus;
    private String account_type;
    private String html;
    private String width;
    private String height;
    private String duration;
    private String description;
    private String thumbnail_width;
    private String thumbnail_height;
    private String thumbnail_url_with_play_button;
    private String upload_date;
    private String video_id;
    private String uri;
}
