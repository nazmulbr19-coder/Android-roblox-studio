package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;
import kotlinx.serialization.modules.SerializersModuleCollector;

/* compiled from: SerializersModule.kt */
@Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0016JQ\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072/\u0010\n\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000bH\u0016JF\u0010\u0010\u001a\u00020\u0003\"\b\b\u0000\u0010\u0011*\u00020\u0005\"\b\b\u0001\u0010\u0012*\u0002H\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\tH\u0016JK\u0010\u0016\u001a\u00020\u0003\"\b\b\u0000\u0010\u0011*\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072)\u0010\u0017\u001a%\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00190\u000bH\u0016JM\u0010\u001a\u001a\u00020\u0003\"\b\b\u0000\u0010\u0011*\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072+\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u001e0\u000bH\u0016¨\u0006\u001f"}, d2 = {"kotlinx/serialization/modules/SerializersModuleKt$overwriteWith$1$1", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "provider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "serializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "", "className", "Lkotlinx/serialization/DeserializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class SerializersModuleKt$overwriteWith$1$1 implements SerializersModuleCollector {
    final /* synthetic */ SerializersModuleBuilder $this_SerializersModule;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SerializersModuleKt$overwriteWith$1$1(SerializersModuleBuilder serializersModuleBuilder) {
        this.$this_SerializersModule = serializersModuleBuilder;
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.$this_SerializersModule.registerSerializer(kClass, new ContextualProvider.WithTypeArguments(provider), true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(KClass<T> kClass, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.$this_SerializersModule.registerSerializer(kClass, new ContextualProvider.Argless(serializer), true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void polymorphic(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        this.$this_SerializersModule.registerPolymorphicSerializer(baseClass, actualClass, actualSerializer, true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
    public <Base> void polymorphicDefault(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        SerializersModuleCollector.DefaultImpls.polymorphicDefault(this, kClass, function1);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        this.$this_SerializersModule.registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, true);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        this.$this_SerializersModule.registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, true);
    }
}
