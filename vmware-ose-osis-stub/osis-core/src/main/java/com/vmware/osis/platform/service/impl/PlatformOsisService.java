/**
 * Copyright 2020 VMware, Inc.
 * SPDX-License-Identifier: Apache License 2.0
 */

package com.vmware.osis.platform.service.impl;

import com.vmware.osis.model.*;
import com.vmware.osis.model.exception.NotImplementedException;
import com.vmware.osis.platform.AppEnv;
import com.vmware.osis.resource.OsisCapsManager;
import com.vmware.osis.service.OsisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;


@Service
public class PlatformOsisService implements OsisService {
    private static final Logger logger = LoggerFactory.getLogger(PlatformOsisService.class);
    private static final String S3_CAPABILITIES_JSON = "s3capabilities.json";
    //@Value("osis.platform.admin.endpoint")
    private static final String HCP_MANAGEMENT_API_URL ="http://localhost:3001/management/rest";

    @Autowired
    private AppEnv appEnv;

    @Lazy
    private OsisCapsManager osisCapsManager;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public OsisTenant createTenant(OsisTenant osisTenant) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfTenants queryTenants(long offset, long limit, String filter) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfTenants listTenants(long offset, long limit) {
        throw new NotImplementedException();
    }

    @Override
    public OsisUser createUser(OsisUser osisUser) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfUsers queryUsers(long offset, long limit, String filter) {
        throw new NotImplementedException();
    }


    @Override
    public OsisS3Credential createS3Credential(String tenantId, String userId) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfS3Credentials queryS3Credentials(long offset, long limit, String filter) {
        throw new NotImplementedException();
    }

    @Override
    public String getProviderConsoleUrl() {
        throw new NotImplementedException();
    }

    @Override
    public String getTenantConsoleUrl(String tenantId) {
        throw new NotImplementedException();
    }

    @Override
    public OsisS3Capabilities getS3Capabilities() {
        throw new NotImplementedException();
    }

    @Override
    public void deleteS3Credential(String tenantId, String userId, String accessKey) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteTenant(String tenantId, Boolean purgeData) {
        throw new NotImplementedException();
    }

    @Override
    public OsisTenant updateTenant(String tenantId, OsisTenant osisTenant) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteUser(String tenantId, String userId, Boolean purgeData) {
        throw new NotImplementedException();
    }

    @Override
    public OsisS3Credential getS3Credential(String accessKey) {
        throw new NotImplementedException();
    }

    @Override
    public OsisTenant getTenant(String tenantId) {
        URL url = null;
        try {
            url = new URL("http://localhost:3001/api/tenants/pqr");//new URL(HCP_MANAGEMENT_API_URL + "/tenants/" + tenantId);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<OsisTenant> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url.toURI(), HttpMethod.GET, requestEntity, OsisTenant.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to get tenant: " + responseEntity.getStatusCode());
        }
    }

    @Override
    public OsisUser getUser(String canonicalUserId) {
        throw new NotImplementedException();
    }

    @Override
    public OsisUser getUser(String tenantId, String userId) {
        throw new NotImplementedException();

    }

    @Override
    public boolean headTenant(String tenantId) {
        throw new NotImplementedException();
    }

    @Override
    public boolean headUser(String tenantId, String userId) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfS3Credentials listS3Credentials(String tenantId, String userId, Long offset, Long limit) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfUsers listUsers(String tenantId, long offset, long limit) {
        throw new NotImplementedException();
    }

    @Override
    public OsisUser updateUser(String tenantId, String userId, OsisUser osisUser) {
        throw new NotImplementedException();
    }

    @Override
    public Information getInformation(String domain) {
        throw new NotImplementedException();
    }

    @Override
    public OsisCaps updateOsisCaps(OsisCaps osisCaps) {
        throw new NotImplementedException();
    }

    @Override
    public PageOfOsisBucketMeta getBucketList(String tenantId, long offset, long limit) {
        throw new NotImplementedException();
    }

    @Override
    public OsisUsage getOsisUsage(Optional<String> tenantId, Optional<String> userId) {
        throw new NotImplementedException();
    }
}
