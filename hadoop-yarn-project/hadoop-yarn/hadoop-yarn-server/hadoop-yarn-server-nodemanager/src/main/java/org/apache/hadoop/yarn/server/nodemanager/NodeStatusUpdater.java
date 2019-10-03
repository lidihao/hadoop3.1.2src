/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.hadoop.yarn.server.nodemanager;

import org.apache.hadoop.service.Service;
import org.apache.hadoop.yarn.api.records.ContainerId;
//当NodeManager启动时，该组件负责向ResourceManager注册，并汇报节点上
//的可用资源，之后，该组件周期性与ResourceManager通信，汇报各个Container的
//状态更新，包括节点上正在运行的Container,已完成的Container的信息，同时ResourceManager
//会为之返回待清理Container列表，待清理应用程序列表，诊断信息，各种Token等信息
public interface NodeStatusUpdater extends Service {

  /**
   * 心跳信息
   * Schedule a heartbeat to the ResourceManager outside of the normal,
   * periodic heartbeating process. This is typically called when the state
   * of containers on the node has changed to notify the RM sooner.
   */
  void sendOutofBandHeartBeat();

  /**
   * Get the ResourceManager identifier received during registration
   * @return the ResourceManager ID
   */
  long getRMIdentifier();
  
  /**
   * Query if a container has recently completed
   * @param containerId the container ID
   * @return true if the container has recently completed
   */
  public boolean isContainerRecentlyStopped(ContainerId containerId);
  
  /**
   * Add a container to the list of containers that have recently completed
   * @param containerId the ID of the completed container
   */
  public void addCompletedContainer(ContainerId containerId);

  /**
   * Clear the list of recently completed containers
   */
  public void clearFinishedContainersFromCache();

  /**
   * Report an unrecoverable exception.
   * @param ex exception that makes the node unhealthy
   */
  void reportException(Exception ex);
}
