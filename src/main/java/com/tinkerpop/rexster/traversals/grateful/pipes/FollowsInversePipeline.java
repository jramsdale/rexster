package com.tinkerpop.rexster.traversals.grateful.pipes;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.filter.ComparisonFilterPipe;
import com.tinkerpop.pipes.pgm.EdgeVertexPipe;
import com.tinkerpop.pipes.pgm.LabelFilterPipe;
import com.tinkerpop.pipes.pgm.VertexEdgePipe;
import com.tinkerpop.rexster.traversals.grateful.GratefulDeadTokens;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FollowsInversePipeline extends Pipeline<Vertex, Vertex> {

    public FollowsInversePipeline() {
        Pipe pipe1 = new VertexEdgePipe(VertexEdgePipe.Step.IN_EDGES);
        Pipe pipe2 = new LabelFilterPipe(GratefulDeadTokens.FOLLOWED_BY, ComparisonFilterPipe.Filter.EQUALS);
        Pipe pipe3 = new EdgeVertexPipe(EdgeVertexPipe.Step.OUT_VERTEX);
        this.setPipes(Arrays.asList(pipe1, pipe2, pipe3));
    }
}