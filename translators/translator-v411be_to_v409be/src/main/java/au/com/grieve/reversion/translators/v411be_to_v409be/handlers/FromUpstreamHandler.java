/*
 * Reversion - Minecraft Protocol Support for Bedrock
 * Copyright (C) 2020 Reversion Developers
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package au.com.grieve.reversion.translators.v411be_to_v409be.handlers;

import au.com.grieve.reversion.translators.v411be_to_v409be.Translator_v411be_to_v409be;
import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class FromUpstreamHandler implements BedrockPacketHandler {
    private final Translator_v411be_to_v409be translator;

    @Override
    public boolean handle(LoginPacket packet) {
        packet.setProtocolVersion(409);
        return false;
    }
}
