package com.github.newk5.vcmp.javascript.cryptomod;

import com.eclipsesource.v8.V8;
import com.github.newk5.vcmp.javascript.plugin.module.Module;
import com.github.newk5.vcmp.javascript.cryptomod.injectables.CryptoWrapper;
import io.alicorn.v8.V8JavaAdapter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

public class CryptoModule extends Plugin {

    public static ThreadPoolExecutor pool;
    private static V8 v8 = com.github.newk5.vcmp.javascript.plugin.internals.Runtime.v8;

    public CryptoModule(PluginWrapper wrapper) {
        super(wrapper);
        this.pool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    @Extension
    public static class Crypto implements Module {

        @Override
        public void inject() {

            V8JavaAdapter.injectObject("CryptoWrapper", new CryptoWrapper(), v8);

        }

        @Override
        public String javascript() {
            InputStream in = CryptoModule.class.getResourceAsStream("module.js");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String code = reader.lines().collect(Collectors.joining("\n"));

            return code;
        }

    }
}
