/*
 * MIT License
 *
 * Copyright (c) 2020 Reversion Developers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package au.com.grieve.reversion.api;

import com.nukkitx.network.util.EventLoops;
import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.BedrockServer;
import io.netty.channel.EventLoopGroup;
import lombok.Getter;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
public abstract class ReversionServer extends BedrockServer {
    private final Set<BedrockPacketCodec> toCodecs;
    private final EventLoopGroup eventLoopGroup;

    public ReversionServer(Collection<BedrockPacketCodec> toCodecs, InetSocketAddress address) {
        this(toCodecs, address, 1);
    }

    public ReversionServer(Collection<BedrockPacketCodec> toCodecs, InetSocketAddress address, int maxThreads) {
        this(toCodecs, address, maxThreads, EventLoops.commonGroup());
    }

    public ReversionServer(Collection<BedrockPacketCodec> toCodecs, InetSocketAddress address, int maxThreads, EventLoopGroup eventLoopGroup) {
        super(address, maxThreads, eventLoopGroup);

        this.eventLoopGroup = eventLoopGroup;
        this.toCodecs = new HashSet<>(toCodecs);
    }

    public ReversionServer(BedrockPacketCodec toCodec, InetSocketAddress address, int maxThreads, EventLoopGroup eventLoopGroup) {
        this(Collections.singleton(toCodec), address, maxThreads, eventLoopGroup);
    }

    public ReversionServer(BedrockPacketCodec toCodec, InetSocketAddress address) {
        this(toCodec, address, 1);
    }

    public ReversionServer(BedrockPacketCodec toCodec, InetSocketAddress address, int maxThreads) {
        this(toCodec, address, maxThreads, EventLoops.commonGroup());
    }

}
