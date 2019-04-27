package org.typroject.tycloud.api.systemctl.face.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.typroject.tycloud.api.systemctl.face.model.LocationInfoModel;
import org.typroject.tycloud.api.systemctl.face.orm.dao.LocationInfoMapper;
import org.typroject.tycloud.api.systemctl.face.orm.entity.LocationInfo;
import org.typroject.tyboot.component.cache.Redis;
import org.typroject.tyboot.component.cache.enumeration.CacheType;
import org.typroject.tyboot.core.rdbms.service.BaseService;

import java.util.List;

/**
 * Created by magintursh on 2017-06-21.
 */
@Service("locationInfoService")
public class LocationInfoService extends BaseService<LocationInfoModel,LocationInfo,LocationInfoMapper> implements IService<LocationInfo> {


    public static final String LOCATIONINFO="LOCATIONINFO";

    public static final String LOCATIONINFO_LIST="LOCATIONINFO_LIST";


    public static final String cacheKeyForLocationinfoModel(String locationCode)
    {
        return Redis.genKey(CacheType.ERASABLE.name(),LOCATIONINFO,locationCode);
    }

    public static final String cacheKeyForLocationList(String parentCode)
    {
        return Redis.genKey(CacheType.ERASABLE.name(),LOCATIONINFO_LIST,parentCode);
    }


    public List<LocationInfoModel> getByParent(String  parentCode) throws Exception
    {
       return this.queryForListWithCache(cacheKeyForLocationList(parentCode),null,false,parentCode);
    }


    public LocationInfoModel getByCode(String  locationCode) throws Exception
    {
        LocationInfoModel model = new LocationInfoModel();
        model.setLocationCode(locationCode);
        return queryByModelWithCache(model,locationCode);
    }




}
