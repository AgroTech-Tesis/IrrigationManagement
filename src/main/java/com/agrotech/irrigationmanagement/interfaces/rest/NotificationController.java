package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.domain.model.queries.GetNotificationAllQuery;
import com.agrotech.irrigationmanagement.domain.services.NotificationCommandService;
import com.agrotech.irrigationmanagement.domain.services.NotificationQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateNotificationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.NotificationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.RiceCropResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("notifications")
public class NotificationController {
    private final NotificationCommandService notificationService;
    private final NotificationQueryService notificationQueryService;
    public NotificationController(NotificationCommandService notificationService, NotificationQueryService notificationQueryService) {
        this.notificationService = notificationService;
        this.notificationQueryService = notificationQueryService;
    }

    @GetMapping()
    @Operation(tags = {"Notification"})
    public ResponseEntity<List<NotificationResource>> getAllNotification(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                         @RequestParam(value = "size", defaultValue = "10") int size) {
        var getNotificationAllQuery = new GetNotificationAllQuery(page, size);
        var notificationList = notificationQueryService.handle(getNotificationAllQuery);

        var notificationResourceList = notificationList.stream().map(NotificationResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(notificationResourceList);
    }
    @PostMapping()
    @Operation(tags = {"Notification"})
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource notificationDto){
        var createNotificationCommand = CreateNotificationCommandFromResourceAssembler.toResourceFromEntity(notificationDto);
        var notification = notificationService.handle(createNotificationCommand);
        if (notification.isEmpty()) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get()));
    }
}
