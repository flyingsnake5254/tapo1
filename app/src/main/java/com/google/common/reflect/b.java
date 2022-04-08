package com.google.common.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Invokable.java */
/* loaded from: classes2.dex */
public abstract class b<T, R> extends a implements GenericDeclaration {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Invokable.java */
    /* loaded from: classes2.dex */
    public static class a<T> extends b<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final Constructor<?> f4751f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Constructor<?> constructor) {
            super(constructor);
            this.f4751f = constructor;
        }

        private boolean c() {
            Class<?> declaringClass = this.f4751f.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return declaringClass.getEnclosingClass() != null && !Modifier.isStatic(declaringClass.getModifiers());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type[] b() {
            Type[] genericParameterTypes = this.f4751f.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f4751f.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f4751f.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Invokable.java */
    /* renamed from: com.google.common.reflect.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0170b<T> extends b<T, Object> {

        /* renamed from: f  reason: collision with root package name */
        final Method f4752f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0170b(Method method) {
            super(method);
            this.f4752f = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f4752f.getTypeParameters();
        }
    }

    <M extends AccessibleObject & Member> b(M m) {
        super(m);
    }

    @Override // com.google.common.reflect.a
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.reflect.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    @Override // com.google.common.reflect.a
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.reflect.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
