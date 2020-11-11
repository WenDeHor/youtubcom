package com.studio.youtubcom.repository;

import com.studio.youtubcom.models.Bot;
import com.studio.youtubcom.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BotRepository extends JpaRepository<Bot, Long> {

}
