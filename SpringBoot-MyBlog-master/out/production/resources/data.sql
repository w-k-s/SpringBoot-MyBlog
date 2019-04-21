INSERT INTO
  blogs (
    id,
    title,
    slug,
    preview,
    body,
    author,
    created_date,
    last_modified_date
  )
VALUES
  (
    1,
    'Yellow (song)',
    'Yellow_(song)',
    ' "Yellow" is a song by English alternative rock band Coldplay ',
    ' \"Yellow\" is a song by English alternative rock band Coldplay. The band wrote the song and co-produced it with British record producer Ken Nelson. It was for their first album Parachutes. The song\'s lyrics are a reference to band vocalist Chris Martin\'s unreturned love.\n\nThe song was released across the world in June 2000. It was the second single off the album following \"Shiver\". It was the lead single in the United States. The single reached number four in the UK Singles Chart. This gave the band their first top-five hit in the United Kingdom.\n\nHelped by heavy rotation and usage in promotions, the song made the band very popular. Various recording artists worldwide have since made their own versions of \"Yellow\". It remains one of the band\'s most popular songs. ',
    'Leonardo di Vinci',
    now(),
    now()
  );


INSERT INTO comments (
    id,
    author,
    body,
    blog_id,
    created_date
) VALUES (
    DEFAULT,
    'Waqqas Sheikh',
    'This post SUCKS!!!',
    1,
    now()
);

--- Blog # 2

INSERT INTO blogs (
    id,
    title,
    slug,
    preview,
    body,
    author,
    created_date,
    last_modified_date
) VALUES (
    2,
    'Jordan Peele',
    'Jordan_Peele',
    'Jordan Peele (born February 21, 1979) is an American actor, movie director, voice talent and comedian',
    'Jordan Peele (born February 21, 1979) is an American actor, movie director, voice talent and comedian.[1] He was born in New York City, New York.\n\nPeele directed and wrote the 2017 horror movie Get Out, for which he won an Academy Award for Best Original Screenplay. ',
    'Jordan Peele',
    now(),
    now()
);

INSERT INTO comments (
    id,
    author,
    body,
    blog_id,
    created_date
) VALUES (
    DEFAULT,
    'Waqqas Sheikh',
    'Get out was such a great movie! Can\'t wait for his next masterpiece',
    2,
    now()
);

INSERT INTO comments (
    id,
    author,
    body,
    blog_id,
    created_date
) VALUES (
    DEFAULT,
    'Doughlas Lameass',
    'This movie SUCKS!!!',
    2,
    now()
);