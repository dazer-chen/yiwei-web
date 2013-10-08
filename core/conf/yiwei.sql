-- article
CREATE TABLE article (
  id        BIGINT AUTO_INCREMENT PRIMARY KEY,
  author    VARCHAR(50)  NOT NULL,
  head      VARCHAR(256) NOT NULL,
  content   MEDIUMBLOB,
  editor    INT,
  tag       VARCHAR(56),
  ctime     TIMESTAMP    NOT NULL,
  uptime    TIMESTAMP,
  category  VARCHAR(256),
  shortname VARCHAR(56),
  medianame VARCHAR(56)
)

#   private String keyword;
#     private String author;
#     private String dutyEditor;
#     private String subhead;
#     private String relativenews;
#     private String pictures;
#     private String pushrecord;
#     private int referid;
#     private String reurl;
#     private String medianame;
#     private String tag;