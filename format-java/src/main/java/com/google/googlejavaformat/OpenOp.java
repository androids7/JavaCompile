

package com.google.googlejavaformat;

import com.google.common.base.MoreObjects;

/**
 * An {@code OpenOp} opens a level. It is an {@link Op} in the sequence of {@link Op}s generated by
 * {@link OpsBuilder}. When the sequence is turned into a {@link Doc} by {@link DocBuilder}, {@link
 * Input.Tok}s delimited by {@code OpenOp}-{@link CloseOp} pairs turn into nested {@link
 * Doc.Level}s.
 */
public final class OpenOp implements Op {
    private final Indent plusIndent;

    private OpenOp(Indent plusIndent) {
        this.plusIndent = plusIndent;
    }

    /**
     * Make an ordinary {@code OpenOp}.
     *
     * @param plusIndent the indent for breaks at this level
     * @return the {@code OpenOp}
     */
    public static Op make(Indent plusIndent) {
        return new OpenOp(plusIndent);
    }

    @Override
    public void add(DocBuilder builder) {
        builder.open(plusIndent);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("plusIndent", plusIndent).toString();
    }
}