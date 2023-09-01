package rs.ac.uns.ftn.svtvezbe07.service;

import java.util.List;
import java.util.Optional;

public interface ClubService {

    List<Club> getAll();
    Optional<Club> getById(Long id);
    Club save(Club club);
}
