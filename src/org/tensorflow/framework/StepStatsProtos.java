// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: step_stats.proto

package org.tensorflow.framework;

public final class StepStatsProtos {
  private StepStatsProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_AllocatorMemoryUsed_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_AllocatorMemoryUsed_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_NodeOutput_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_NodeOutput_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_MemoryStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_MemoryStats_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_NodeExecStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_NodeExecStats_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_DeviceStepStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_DeviceStepStats_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_StepStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_StepStats_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020step_stats.proto\022\ntensorflow\0326tensorfl" +
      "ow/core/framework/allocation_description" +
      ".proto\0322tensorflow/core/framework/tensor" +
      "_description.proto\"\212\001\n\023AllocatorMemoryUs" +
      "ed\022\026\n\016allocator_name\030\001 \001(\t\022\023\n\013total_byte" +
      "s\030\002 \001(\003\022\022\n\npeak_bytes\030\003 \001(\003\022\022\n\nlive_byte" +
      "s\030\004 \001(\003\022\036\n\026allocator_bytes_in_use\030\005 \001(\003\"" +
      "U\n\nNodeOutput\022\014\n\004slot\030\001 \001(\005\0229\n\022tensor_de" +
      "scription\030\003 \001(\0132\035.tensorflow.TensorDescr" +
      "iption\"\357\001\n\013MemoryStats\022\035\n\025host_temp_memo",
      "ry_size\030\001 \001(\003\022\037\n\027device_temp_memory_size" +
      "\030\002 \001(\003\022#\n\033host_persistent_memory_size\030\003 " +
      "\001(\003\022%\n\035device_persistent_memory_size\030\004 \001" +
      "(\003\022(\n host_persistent_tensor_alloc_ids\030\005" +
      " \003(\003\022*\n\"device_persistent_tensor_alloc_i" +
      "ds\030\006 \003(\003\"\233\003\n\rNodeExecStats\022\021\n\tnode_name\030" +
      "\001 \001(\t\022\030\n\020all_start_micros\030\002 \001(\003\022\033\n\023op_st" +
      "art_rel_micros\030\003 \001(\003\022\031\n\021op_end_rel_micro" +
      "s\030\004 \001(\003\022\032\n\022all_end_rel_micros\030\005 \001(\003\022/\n\006m" +
      "emory\030\006 \003(\0132\037.tensorflow.AllocatorMemory",
      "Used\022&\n\006output\030\007 \003(\0132\026.tensorflow.NodeOu" +
      "tput\022\026\n\016timeline_label\030\010 \001(\t\022\030\n\020schedule" +
      "d_micros\030\t \001(\003\022\021\n\tthread_id\030\n \001(\r\022<\n\021ref" +
      "erenced_tensor\030\013 \003(\0132!.tensorflow.Alloca" +
      "tionDescription\022-\n\014memory_stats\030\014 \001(\0132\027." +
      "tensorflow.MemoryStats\"P\n\017DeviceStepStat" +
      "s\022\016\n\006device\030\001 \001(\t\022-\n\nnode_stats\030\002 \003(\0132\031." +
      "tensorflow.NodeExecStats\";\n\tStepStats\022.\n" +
      "\tdev_stats\030\001 \003(\0132\033.tensorflow.DeviceStep" +
      "StatsB0\n\030org.tensorflow.frameworkB\017StepS",
      "tatsProtosP\001\370\001\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.tensorflow.framework.AllocationDescriptionProtos.getDescriptor(),
          org.tensorflow.framework.TensorDescriptionProtos.getDescriptor(),
        }, assigner);
    internal_static_tensorflow_AllocatorMemoryUsed_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tensorflow_AllocatorMemoryUsed_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_AllocatorMemoryUsed_descriptor,
        new java.lang.String[] { "AllocatorName", "TotalBytes", "PeakBytes", "LiveBytes", "AllocatorBytesInUse", });
    internal_static_tensorflow_NodeOutput_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tensorflow_NodeOutput_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_NodeOutput_descriptor,
        new java.lang.String[] { "Slot", "TensorDescription", });
    internal_static_tensorflow_MemoryStats_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tensorflow_MemoryStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_MemoryStats_descriptor,
        new java.lang.String[] { "HostTempMemorySize", "DeviceTempMemorySize", "HostPersistentMemorySize", "DevicePersistentMemorySize", "HostPersistentTensorAllocIds", "DevicePersistentTensorAllocIds", });
    internal_static_tensorflow_NodeExecStats_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_tensorflow_NodeExecStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_NodeExecStats_descriptor,
        new java.lang.String[] { "NodeName", "AllStartMicros", "OpStartRelMicros", "OpEndRelMicros", "AllEndRelMicros", "Memory", "Output", "TimelineLabel", "ScheduledMicros", "ThreadId", "ReferencedTensor", "MemoryStats", });
    internal_static_tensorflow_DeviceStepStats_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_tensorflow_DeviceStepStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_DeviceStepStats_descriptor,
        new java.lang.String[] { "Device", "NodeStats", });
    internal_static_tensorflow_StepStats_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_tensorflow_StepStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_StepStats_descriptor,
        new java.lang.String[] { "DevStats", });
    org.tensorflow.framework.AllocationDescriptionProtos.getDescriptor();
    org.tensorflow.framework.TensorDescriptionProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
