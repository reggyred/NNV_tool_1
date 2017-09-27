// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: step_stats.proto

package org.tensorflow.framework;

/**
 * <pre>
 * Output sizes recorded for a single execution of a graph node.
 * </pre>
 *
 * Protobuf type {@code tensorflow.NodeOutput}
 */
public  final class NodeOutput extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.NodeOutput)
    NodeOutputOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NodeOutput.newBuilder() to construct.
  private NodeOutput(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NodeOutput() {
    slot_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NodeOutput(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            slot_ = input.readInt32();
            break;
          }
          case 26: {
            org.tensorflow.framework.TensorDescription.Builder subBuilder = null;
            if (tensorDescription_ != null) {
              subBuilder = tensorDescription_.toBuilder();
            }
            tensorDescription_ = input.readMessage(org.tensorflow.framework.TensorDescription.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(tensorDescription_);
              tensorDescription_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.framework.StepStatsProtos.internal_static_tensorflow_NodeOutput_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.framework.StepStatsProtos.internal_static_tensorflow_NodeOutput_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.framework.NodeOutput.class, org.tensorflow.framework.NodeOutput.Builder.class);
  }

  public static final int SLOT_FIELD_NUMBER = 1;
  private int slot_;
  /**
   * <code>int32 slot = 1;</code>
   */
  public int getSlot() {
    return slot_;
  }

  public static final int TENSOR_DESCRIPTION_FIELD_NUMBER = 3;
  private org.tensorflow.framework.TensorDescription tensorDescription_;
  /**
   * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
   */
  public boolean hasTensorDescription() {
    return tensorDescription_ != null;
  }
  /**
   * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
   */
  public org.tensorflow.framework.TensorDescription getTensorDescription() {
    return tensorDescription_ == null ? org.tensorflow.framework.TensorDescription.getDefaultInstance() : tensorDescription_;
  }
  /**
   * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
   */
  public org.tensorflow.framework.TensorDescriptionOrBuilder getTensorDescriptionOrBuilder() {
    return getTensorDescription();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (slot_ != 0) {
      output.writeInt32(1, slot_);
    }
    if (tensorDescription_ != null) {
      output.writeMessage(3, getTensorDescription());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (slot_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, slot_);
    }
    if (tensorDescription_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getTensorDescription());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.tensorflow.framework.NodeOutput)) {
      return super.equals(obj);
    }
    org.tensorflow.framework.NodeOutput other = (org.tensorflow.framework.NodeOutput) obj;

    boolean result = true;
    result = result && (getSlot()
        == other.getSlot());
    result = result && (hasTensorDescription() == other.hasTensorDescription());
    if (hasTensorDescription()) {
      result = result && getTensorDescription()
          .equals(other.getTensorDescription());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SLOT_FIELD_NUMBER;
    hash = (53 * hash) + getSlot();
    if (hasTensorDescription()) {
      hash = (37 * hash) + TENSOR_DESCRIPTION_FIELD_NUMBER;
      hash = (53 * hash) + getTensorDescription().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.framework.NodeOutput parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.NodeOutput parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.NodeOutput parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.NodeOutput parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.tensorflow.framework.NodeOutput prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Output sizes recorded for a single execution of a graph node.
   * </pre>
   *
   * Protobuf type {@code tensorflow.NodeOutput}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.NodeOutput)
      org.tensorflow.framework.NodeOutputOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.framework.StepStatsProtos.internal_static_tensorflow_NodeOutput_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.framework.StepStatsProtos.internal_static_tensorflow_NodeOutput_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.framework.NodeOutput.class, org.tensorflow.framework.NodeOutput.Builder.class);
    }

    // Construct using org.tensorflow.framework.NodeOutput.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      slot_ = 0;

      if (tensorDescriptionBuilder_ == null) {
        tensorDescription_ = null;
      } else {
        tensorDescription_ = null;
        tensorDescriptionBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.framework.StepStatsProtos.internal_static_tensorflow_NodeOutput_descriptor;
    }

    public org.tensorflow.framework.NodeOutput getDefaultInstanceForType() {
      return org.tensorflow.framework.NodeOutput.getDefaultInstance();
    }

    public org.tensorflow.framework.NodeOutput build() {
      org.tensorflow.framework.NodeOutput result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.tensorflow.framework.NodeOutput buildPartial() {
      org.tensorflow.framework.NodeOutput result = new org.tensorflow.framework.NodeOutput(this);
      result.slot_ = slot_;
      if (tensorDescriptionBuilder_ == null) {
        result.tensorDescription_ = tensorDescription_;
      } else {
        result.tensorDescription_ = tensorDescriptionBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.tensorflow.framework.NodeOutput) {
        return mergeFrom((org.tensorflow.framework.NodeOutput)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.framework.NodeOutput other) {
      if (other == org.tensorflow.framework.NodeOutput.getDefaultInstance()) return this;
      if (other.getSlot() != 0) {
        setSlot(other.getSlot());
      }
      if (other.hasTensorDescription()) {
        mergeTensorDescription(other.getTensorDescription());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.tensorflow.framework.NodeOutput parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.framework.NodeOutput) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int slot_ ;
    /**
     * <code>int32 slot = 1;</code>
     */
    public int getSlot() {
      return slot_;
    }
    /**
     * <code>int32 slot = 1;</code>
     */
    public Builder setSlot(int value) {
      
      slot_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 slot = 1;</code>
     */
    public Builder clearSlot() {
      
      slot_ = 0;
      onChanged();
      return this;
    }

    private org.tensorflow.framework.TensorDescription tensorDescription_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.tensorflow.framework.TensorDescription, org.tensorflow.framework.TensorDescription.Builder, org.tensorflow.framework.TensorDescriptionOrBuilder> tensorDescriptionBuilder_;
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public boolean hasTensorDescription() {
      return tensorDescriptionBuilder_ != null || tensorDescription_ != null;
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public org.tensorflow.framework.TensorDescription getTensorDescription() {
      if (tensorDescriptionBuilder_ == null) {
        return tensorDescription_ == null ? org.tensorflow.framework.TensorDescription.getDefaultInstance() : tensorDescription_;
      } else {
        return tensorDescriptionBuilder_.getMessage();
      }
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public Builder setTensorDescription(org.tensorflow.framework.TensorDescription value) {
      if (tensorDescriptionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        tensorDescription_ = value;
        onChanged();
      } else {
        tensorDescriptionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public Builder setTensorDescription(
        org.tensorflow.framework.TensorDescription.Builder builderForValue) {
      if (tensorDescriptionBuilder_ == null) {
        tensorDescription_ = builderForValue.build();
        onChanged();
      } else {
        tensorDescriptionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public Builder mergeTensorDescription(org.tensorflow.framework.TensorDescription value) {
      if (tensorDescriptionBuilder_ == null) {
        if (tensorDescription_ != null) {
          tensorDescription_ =
            org.tensorflow.framework.TensorDescription.newBuilder(tensorDescription_).mergeFrom(value).buildPartial();
        } else {
          tensorDescription_ = value;
        }
        onChanged();
      } else {
        tensorDescriptionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public Builder clearTensorDescription() {
      if (tensorDescriptionBuilder_ == null) {
        tensorDescription_ = null;
        onChanged();
      } else {
        tensorDescription_ = null;
        tensorDescriptionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public org.tensorflow.framework.TensorDescription.Builder getTensorDescriptionBuilder() {
      
      onChanged();
      return getTensorDescriptionFieldBuilder().getBuilder();
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    public org.tensorflow.framework.TensorDescriptionOrBuilder getTensorDescriptionOrBuilder() {
      if (tensorDescriptionBuilder_ != null) {
        return tensorDescriptionBuilder_.getMessageOrBuilder();
      } else {
        return tensorDescription_ == null ?
            org.tensorflow.framework.TensorDescription.getDefaultInstance() : tensorDescription_;
      }
    }
    /**
     * <code>.tensorflow.TensorDescription tensor_description = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.tensorflow.framework.TensorDescription, org.tensorflow.framework.TensorDescription.Builder, org.tensorflow.framework.TensorDescriptionOrBuilder> 
        getTensorDescriptionFieldBuilder() {
      if (tensorDescriptionBuilder_ == null) {
        tensorDescriptionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.tensorflow.framework.TensorDescription, org.tensorflow.framework.TensorDescription.Builder, org.tensorflow.framework.TensorDescriptionOrBuilder>(
                getTensorDescription(),
                getParentForChildren(),
                isClean());
        tensorDescription_ = null;
      }
      return tensorDescriptionBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:tensorflow.NodeOutput)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.NodeOutput)
  private static final org.tensorflow.framework.NodeOutput DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.framework.NodeOutput();
  }

  public static org.tensorflow.framework.NodeOutput getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NodeOutput>
      PARSER = new com.google.protobuf.AbstractParser<NodeOutput>() {
    public NodeOutput parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new NodeOutput(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NodeOutput> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NodeOutput> getParserForType() {
    return PARSER;
  }

  public org.tensorflow.framework.NodeOutput getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

