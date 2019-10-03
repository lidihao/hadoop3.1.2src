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

package org.apache.hadoop.yarn.server.resourcemanager.rmnode;

public enum RMNodeEventType {
  
  STARTED,
  
  // Source: AdminService
  DECOMMISSION,
  GRACEFUL_DECOMMISSION,
  RECOMMISSION,
  
  // Source: AdminService, ResourceTrackerService
  RESOURCE_UPDATE,

  // ResourceTrackerService
  // NodeManager会通过RPC函数ResourceTracker#nodeHeartbeat周期性向RM汇报心跳信息,而每次汇报心跳
  // 均会触发一个STATUS_UPDATE事件
  STATUS_UPDATE,
  REBOOTING,
  RECONNECTED,
  SHUTDOWN,

  // Source: Application
  CLEANUP_APP,

  // Source: Container
  CONTAINER_ALLOCATED,
  // 当一个Container执行完(可能成功或失败)，会触发这个事件，以清理Container占用的资源
  CLEANUP_CONTAINER,
  UPDATE_CONTAINER,

  // Source: ClientRMService
  SIGNAL_CONTAINER,

  // Source: RMAppAttempt
  FINISHED_CONTAINERS_PULLED_BY_AM,

  // Source: NMLivelinessMonitor
  EXPIRE
}
