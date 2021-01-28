package by.grodno.pvt.site.webappsample.dto;


import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.domain.WorkScale;
import lombok.Data;

import java.util.Date;

@Data
public class RequestFormDTO {
    private Integer id;
    private Date completionDate;
    private User user;
    private WorkScale heatSupplyWorkScale;
    private WorkScale powerSupplyWorkScale;
    private WorkScale waterSupplyWorkScale;
}
