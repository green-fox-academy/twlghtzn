package com.twlghtzn.workshop.services;

import com.twlghtzn.workshop.models.Author;
import com.twlghtzn.workshop.models.Genre;
import com.twlghtzn.workshop.models.Song;
import com.twlghtzn.workshop.models.SongRequest;
import com.twlghtzn.workshop.models.Year;
import com.twlghtzn.workshop.repositories.AuthorRepository;
import com.twlghtzn.workshop.repositories.GenreRepository;
import com.twlghtzn.workshop.repositories.SongRepository;
import com.twlghtzn.workshop.repositories.YearRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SongService {
  private SongRepository songRepository;
  private AuthorRepository authorRepository;
  private YearRepository yearRepository;
  private GenreRepository genreRepository;

  public SongService(SongRepository songRepository,
                     AuthorRepository authorRepository,
                     YearRepository yearRepository,
                     GenreRepository genreRepository) {
    this.songRepository = songRepository;
    this.authorRepository = authorRepository;
    this.yearRepository = yearRepository;
    this.genreRepository = genreRepository;
    fillAuthors();
    fillGenres();
    fillYears();
    fillSongs();
  }

  public void addSongFromSongRequest(SongRequest songRequest) {
    addSong(songRequest.getAuthor(), songRequest.getTitle(), songRequest.getGenre(),
        songRequest.getYear());
  }

  public List<Song> getAllSongs() {
    return songRepository.findAll();
  }

  public void addSong(String author, String title, String genre, int year) {
    addAuthor(author);
    addGenre(genre);
    addYear(year);
    songRepository.save(new Song(authorRepository.findAuthorByName(author), title,
        genreRepository.findGenreByName(genre), yearRepository.findYearByYear(year)));
  }

  public void addAuthor(String name) {
    if (!isAuthorSaved(name)) {
      authorRepository.save(new Author(name));
    }
  }

  public void addGenre(String name) {
    if (!isGenreSaved(name)) {
      genreRepository.save(new Genre(name));
    }
  }

  public void addYear(int year) {
    if (!isYearSaved(year)) {
      yearRepository.save(new Year(year));
    }
  }

  public boolean isAuthorSaved(String name) {
    return authorRepository.findAuthorByName(name) != null;
  }

  public boolean isGenreSaved(String name) {
    return genreRepository.findGenreByName(name) != null;
  }

  public boolean isYearSaved(int year) {
    return yearRepository.findYearByYear(year) != null;
  }

  public void fillSongs() {
    addSong("Electric Light Orchestra", "Mr. Blue Sky", "Rock", 1977);
    addSong("Blue Swede", "Hooked On A Feeling", "Pop rock", 1968);
    addSong("Raspberries", "Go All The Way", "Classic rock", 1972);
    addSong("The Runaways", "Cherry Bomb", "Rock", 1976);
    addSong("Ram Jam", "Black Betty", "Rock", 1977);
  }

  public void fillAuthors() {
    authorRepository.save(new Author("Electric Light Orchestra"));
    authorRepository.save(new Author("Blue Swede"));
    authorRepository.save(new Author("Raspberries"));
    authorRepository.save(new Author("The Runaways"));
    authorRepository.save(new Author("Ram Jam"));
  }

  public void fillYears() {
    yearRepository.save(new Year(1977));
    yearRepository.save(new Year(1968));
    yearRepository.save(new Year(1972));
    yearRepository.save(new Year(1976));
  }

  public void fillGenres() {
    genreRepository.save(new Genre("Rock"));
    genreRepository.save(new Genre("Pop rock"));
    genreRepository.save(new Genre("Classic rock"));
  }
}
