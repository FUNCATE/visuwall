package com.jsmadja.wall.projectwall.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.jsmadja.wall.projectwall.domain.Wall;

@Service
public class WallService {

    private List<Wall> walls = new ArrayList<Wall>();

    private static final Logger LOG = LoggerFactory.getLogger(WallService.class);

    public WallService() {
        if (LOG.isInfoEnabled()) {
            LOG.info("WallService is starting ...");
        }
    }

    @Scheduled(fixedDelay=5*60*1000)
    public synchronized void refreshWalls() {
        for(Wall wall:walls) {
            if (LOG.isInfoEnabled()) {
                LOG.info("Refreshing wall : "+wall);
            }
            wall.refreshProjects();
        }
    }

    public synchronized void addWall(Wall wall) {
        Preconditions.checkNotNull(wall);
        walls.add(wall);
    }
}
