package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.firebase.messaging.ServiceStarter;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzea {
    public static final zzdz<Integer> zzE;
    public static final zzdz<Integer> zzG;
    public static final zzdz<Boolean> zzJ;
    public static final zzdz<Double> zzN;
    public static final zzdz<Boolean> zzR;
    public static final zzdz<Boolean> zzS;
    public static final zzdz<Boolean> zzT;
    public static final zzdz<Boolean> zzU;
    public static final zzdz<Boolean> zzV;
    public static final zzdz<Boolean> zzW;
    public static final zzdz<Boolean> zzX;
    public static final zzdz<Boolean> zzY;
    public static final zzdz<Boolean> zzZ;
    public static final zzdz<Boolean> zzaA;
    public static final zzdz<Boolean> zzaB;
    public static final zzdz<Boolean> zzaC;
    public static final zzdz<Boolean> zzaD;
    public static final zzdz<Boolean> zzaE;
    public static final zzdz<Boolean> zzaF;
    public static final zzdz<Boolean> zzaa;
    public static final zzdz<Boolean> zzab;
    public static final zzdz<Boolean> zzac;
    public static final zzdz<Boolean> zzad;
    public static final zzdz<Boolean> zzae;
    public static final zzdz<Boolean> zzaf;
    public static final zzdz<Boolean> zzag;
    public static final zzdz<Boolean> zzah;
    public static final zzdz<Boolean> zzai;
    public static final zzdz<Boolean> zzaj;
    public static final zzdz<Boolean> zzak;
    public static final zzdz<Boolean> zzal;
    public static final zzdz<Boolean> zzam;
    public static final zzdz<Boolean> zzan;
    public static final zzdz<Boolean> zzao;
    public static final zzdz<Boolean> zzap;
    public static final zzdz<Boolean> zzaq;
    public static final zzdz<Boolean> zzar;
    public static final zzdz<Boolean> zzas;
    public static final zzdz<Boolean> zzat;
    public static final zzdz<Boolean> zzav;
    public static final zzdz<Boolean> zzaw;
    public static final zzdz<Boolean> zzax;
    public static final zzdz<Boolean> zzay;
    public static final zzdz<Boolean> zzaz;
    public static final zzdz<Long> zzz;
    private static final List<zzdz<?>> zzaG = Collections.synchronizedList(new ArrayList());
    private static final Set<zzdz<?>> zzaH = Collections.synchronizedSet(new HashSet());
    public static final zzdz<Long> zza = zzb("measurement.ad_id_cache_time", 10000L, 10000L, zzau.zza);
    public static final zzdz<Long> zzb = zzb("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzbf.zza);
    public static final zzdz<Long> zzc = zzb("measurement.config.cache_time", 86400000L, 3600000L, zzbq.zza);
    public static final zzdz<String> zzd = zzb("measurement.config.url_scheme", "https", "https", zzcb.zza);
    public static final zzdz<String> zze = zzb("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcm.zza);
    public static final zzdz<Integer> zzf = zzb("measurement.upload.max_bundles", 100, 100, zzcx.zza);
    public static final zzdz<Integer> zzg = zzb("measurement.upload.max_batch_size", 65536, 65536, zzdi.zza);
    public static final zzdz<Integer> zzh = zzb("measurement.upload.max_bundle_size", 65536, 65536, zzdt.zza);
    public static final zzdz<Integer> zzi = zzb("measurement.upload.max_events_per_bundle", 1000, 1000, zzdu.zza);
    public static final zzdz<Integer> zzj = zzb("measurement.upload.max_events_per_day", 100000, 100000, zzdv.zza);
    public static final zzdz<Integer> zzk = zzb("measurement.upload.max_error_events_per_day", 1000, 1000, zzav.zza);
    public static final zzdz<Integer> zzl = zzb("measurement.upload.max_public_events_per_day", 50000, 50000, zzaw.zza);
    public static final zzdz<Integer> zzm = zzb("measurement.upload.max_conversions_per_day", 10000, 10000, zzax.zza);
    public static final zzdz<Integer> zzn = zzb("measurement.upload.max_realtime_events_per_day", 10, 10, zzay.zza);
    public static final zzdz<Integer> zzo = zzb("measurement.store.max_stored_events_per_app", 100000, 100000, zzaz.zza);
    public static final zzdz<String> zzp = zzb("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzba.zza);
    public static final zzdz<Long> zzq = zzb("measurement.upload.backoff_period", 43200000L, 43200000L, zzbb.zza);
    public static final zzdz<Long> zzr = zzb("measurement.upload.window_interval", 3600000L, 3600000L, zzbc.zza);
    public static final zzdz<Long> zzs = zzb("measurement.upload.interval", 3600000L, 3600000L, zzbd.zza);
    public static final zzdz<Long> zzt = zzb("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbe.zza);
    public static final zzdz<Long> zzu = zzb("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbg.zza);
    public static final zzdz<Long> zzv = zzb("measurement.upload.minimum_delay", 500L, 500L, zzbh.zza);
    public static final zzdz<Long> zzw = zzb("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbi.zza);
    public static final zzdz<Long> zzx = zzb("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbj.zza);
    public static final zzdz<Long> zzy = zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbk.zza);
    public static final zzdz<Long> zzA = zzb("measurement.upload.retry_time", 1800000L, 1800000L, zzbm.zza);
    public static final zzdz<Integer> zzB = zzb("measurement.upload.retry_count", 6, 6, zzbn.zza);
    public static final zzdz<Long> zzC = zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbo.zza);
    public static final zzdz<Integer> zzD = zzb("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbp.zza);
    public static final zzdz<Integer> zzF = zzb("measurement.upload.max_public_user_properties", 25, 25, null);
    public static final zzdz<Integer> zzH = zzb("measurement.upload.max_public_event_params", 25, 25, null);
    public static final zzdz<Long> zzI = zzb("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbs.zza);
    public static final zzdz<String> zzK = zzb("measurement.test.string_flag", "---", "---", zzbu.zza);
    public static final zzdz<Long> zzL = zzb("measurement.test.long_flag", -1L, -1L, zzbv.zza);
    public static final zzdz<Integer> zzM = zzb("measurement.test.int_flag", -2, -2, zzbw.zza);
    public static final zzdz<Integer> zzO = zzb("measurement.experiment.max_ids", 50, 50, zzby.zza);
    public static final zzdz<Integer> zzP = zzb("measurement.max_bundles_per_iteration", 100, 100, zzbz.zza);
    public static final zzdz<Long> zzQ = zzb("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzca.zza);
    public static final zzdz<Integer> zzau = zzb("measurement.service.storage_consent_support_version", 203600, 203600, zzdg.zza);

    static {
        Long valueOf = Long.valueOf((long) AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
        zzz = zzb("measurement.upload.initial_upload_delay_time", valueOf, valueOf, zzbl.zza);
        Integer valueOf2 = Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        zzE = zzb("measurement.audience.filter_result_max_count", valueOf2, valueOf2, zzbr.zza);
        Integer valueOf3 = Integer.valueOf((int) ServiceStarter.ERROR_UNKNOWN);
        zzG = zzb("measurement.upload.max_event_name_cardinality", valueOf3, valueOf3, null);
        Boolean bool = Boolean.FALSE;
        zzJ = zzb("measurement.test.boolean_flag", bool, bool, zzbt.zza);
        Double valueOf4 = Double.valueOf(-3.0d);
        zzN = zzb("measurement.test.double_flag", valueOf4, valueOf4, zzbx.zza);
        zzR = zzb("measurement.validation.internal_limits_internal_event_params", bool, bool, zzcc.zza);
        Boolean bool2 = Boolean.TRUE;
        zzS = zzb("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, zzcd.zza);
        zzT = zzb("measurement.collection.redundant_engagement_removal_enabled", bool, bool, zzce.zza);
        zzU = zzb("measurement.collection.log_event_and_bundle_v2", bool2, bool2, zzcf.zza);
        zzV = zzb("measurement.quality.checksum", bool, bool, null);
        zzW = zzb("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, zzcg.zza);
        zzX = zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, zzch.zza);
        zzY = zzb("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, zzci.zza);
        zzZ = zzb("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, zzcj.zza);
        zzaa = zzb("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, zzck.zza);
        zzab = zzb("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, zzcl.zza);
        zzac = zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, zzcn.zza);
        zzad = zzb("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, zzco.zza);
        zzae = zzb("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, zzcp.zza);
        zzaf = zzb("measurement.upload.file_lock_state_check", bool2, bool2, zzcq.zza);
        zzag = zzb("measurement.ga.ga_app_id", bool, bool, zzcr.zza);
        zzah = zzb("measurement.lifecycle.app_in_background_parameter", bool, bool, zzcs.zza);
        zzai = zzb("measurement.integration.disable_firebase_instance_id", bool, bool, zzct.zza);
        zzaj = zzb("measurement.lifecycle.app_backgrounded_engagement", bool, bool, zzcu.zza);
        zzak = zzb("measurement.collection.service.update_with_analytics_fix", bool, bool, zzcv.zza);
        zzal = zzb("measurement.service.use_appinfo_modified", bool2, bool2, zzcw.zza);
        zzam = zzb("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, zzcy.zza);
        zzan = zzb("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, zzcz.zza);
        zzao = zzb("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, zzda.zza);
        zzap = zzb("measurement.upload.file_truncate_fix", bool, bool, zzdb.zza);
        zzaq = zzb("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, zzdc.zza);
        zzar = zzb("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, zzdd.zza);
        zzas = zzb("measurement.collection.synthetic_data_mitigation", bool, bool, zzde.zza);
        zzat = zzb("measurement.androidId.delete_feature", bool2, bool2, zzdf.zza);
        zzav = zzb("measurement.upload.directly_maybe_log_error_events", bool2, bool2, zzdh.zza);
        zzaw = zzb("measurement.frontend.directly_maybe_log_error_events", bool, bool, zzdj.zza);
        zzax = zzb("measurement.client.properties.non_null_origin", bool2, bool2, zzdk.zza);
        zzay = zzb("measurement.client.click_identifier_control.dev", bool, bool, zzdl.zza);
        zzaz = zzb("measurement.service.click_identifier_control", bool, bool, zzdm.zza);
        zzaA = zzb("measurement.client.reject_blank_user_id", bool2, bool2, zzdn.zza);
        zzaB = zzb("measurement.config.persist_last_modified", bool2, bool2, zzdo.zza);
        zzaC = zzb("measurement.client.consent.suppress_1p_in_ga4f_install", bool2, bool2, zzdp.zza);
        zzaD = zzb("measurement.module.pixie.ees", bool, bool, zzdq.zza);
        zzaE = zzb("measurement.euid.client.dev", bool, bool, zzdr.zza);
        zzaF = zzb("measurement.euid.service", bool, bool, zzds.zza);
    }

    public static Map<String, String> zza(Context context) {
        zzha zza2 = zzha.zza(context.getContentResolver(), zzhk.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zzb();
    }

    @VisibleForTesting
    static <V> zzdz<V> zzb(String str, V v, V v2, zzdx<V> zzdxVar) {
        zzdz<V> zzdzVar = new zzdz<>(str, v, v2, zzdxVar, null);
        zzaG.add(zzdzVar);
        return zzdzVar;
    }

    public static /* synthetic */ List zzc() {
        return zzaG;
    }
}
